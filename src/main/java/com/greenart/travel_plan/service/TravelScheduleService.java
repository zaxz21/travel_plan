package com.greenart.travel_plan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TravelDetailScheduleEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;
import com.greenart.travel_plan.repository.BasicScheduleViewReposttory;
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.repository.TravelDetailListRepository;
import com.greenart.travel_plan.repository.TravelDetailScheduleRepository;
import com.greenart.travel_plan.repository.TravelPlaceRepository;
import com.greenart.travel_plan.repository.TravelScheduleRepository;
import com.greenart.travel_plan.repository.TsTpConnectionRepository;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleListVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleVO;
import com.greenart.travel_plan.vo.schedule.ScheduleDeleteVO;

import lombok.RequiredArgsConstructor;

//    BasicScheduleListVO bvo = BasicScheduleListVO.builder().img(dlist.get(i).getTdsEntity().getTsTpEntity().getTpEntity().getTpImage()).
//                 // place(dlist.get(i).getTdsEntity().getTsTpEntity().getTpEntity().getTpName()).
//                 name(dlist.get(i).getTdsEntity().getTsTpEntity().getTsEntity().getTsName()).
//                 startDate(dlist.get(i).getTdsEntity().getTsTpEntity().getTsEntity().getTsStartDate()).
//                 endDate(dlist.get(i).getTdsEntity().getTsTpEntity().getTsEntity().getTsEndDate()).build();
//                 basic.add(bvo);

@Service
@RequiredArgsConstructor
public class TravelScheduleService {
    private final TravelScheduleRepository travelScheduleRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final TravelPlaceRepository travelPlaceRepository;
    private final TsTpConnectionRepository tsTpConnectionRepository;
    private final TravelDetailScheduleRepository travelDetailScheduleRepository;
    private final TravelDetailListRepository travelDetailListRepository;
    private final BasicScheduleViewReposttory basicScheduleViewReposttory;
    public MemberAddReponseVO addBasicSchedule (BasicScheduleVO data ) {
        MemberInfoEntity member = memberInfoRepository.findByMiSeq(data.getMiSeq());
        TravelPlaceEntity place =  travelPlaceRepository.findById(data.getTpSeq()).orElse(null);

        if(member ==  null) {
            MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("로그인 후 이용 가능합니다.").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
            return reponse;
        }
        else if (place == null ){
            MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("등록되지 않은 여행지 입니다.").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
            return reponse;
        }
        else{
            TravelScheduleEntity travel = 
            TravelScheduleEntity.builder().tsStartDate(data.getTsStartDate()).tsEndDate(data.getTsEndDate()).tsName(data.getTsName()).memberEntity(member).build();
            travelScheduleRepository.save(travel) ;

            TsTpConnectionEntity connect = TsTpConnectionEntity.builder().tsEntity(travel).tpEntity(place).build();
            tsTpConnectionRepository.save(connect);

            MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("일정 추가 완료").status(true).code(HttpStatus.OK).build();
            return reponse;
        }
    }

    public MemberAddReponseVO addDetailSchedule (DetailScheduleVO data) {
        TravelScheduleEntity travel = travelScheduleRepository.findById(data.getTsSeq()).orElse(null);
        TravelPlaceEntity place = travelPlaceRepository.findById(data.getTpSeq()).orElse(null);
        TsTpConnectionEntity connect = tsTpConnectionRepository.findByTsEntityAndTpEntity(travel, place);
        // if(travel == null || place == null){
        //      MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("").status(false).code(HttpStatus.BAD_GATEWAY).build();
        //     return reponse;
        // }
        
        Boolean sData = travel.getTsStartDate().isBefore(data.getData());
        Boolean eData = travel.getTsEndDate().isAfter(data.getData());
        
        if(sData == false || eData == false) {
            MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("여행 시작 전 혹은 종료 후 날짜는 입력할 수 없습니다.").status(false).code(HttpStatus.BAD_GATEWAY).build();
            return reponse;
        }
        else{
        TravelDetailScheduleEntity detail = TravelDetailScheduleEntity.builder().tdsDate(data.getData()).tsTpEntity(connect).build();
        travelDetailScheduleRepository.save(detail);
        TravelDetailListEntity dList = TravelDetailListEntity.builder().tdsEntity(detail).build();
        travelDetailListRepository.save(dList);
             MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("일정이 추가됐습니다.").status(true).code(HttpStatus.OK).build();
             return reponse;
        }
        }
        public List<BasicScheduleListVO> getMemberSchedule(Long miseq) {
            
            MemberInfoEntity member = memberInfoRepository.findById(miseq).orElse(null);
            List<TravelScheduleEntity> travel =  travelScheduleRepository.findByMemberEntity(member);
            List<TsTpConnectionEntity> connect = new ArrayList<TsTpConnectionEntity>();
            // List<TravelDetailScheduleEntity> detail = new ArrayList<TravelDetailScheduleEntity>();
            // List<TravelDetailListEntity> dlist = new ArrayList<TravelDetailListEntity>();
            List <BasicScheduleListVO> basic = new ArrayList<BasicScheduleListVO>();
            for(int i =0 ;i<travel.size();i++){
                connect.addAll(tsTpConnectionRepository.findByTsEntity(travel.get(i)));
                BasicScheduleListVO bvo = BasicScheduleListVO.builder().
                travel(basicScheduleViewReposttory.findByMiSeq(miseq)).build();
                basic.add(bvo);
            }
            return basic;
            // for (int i = 0; i<connect.size();i++){
            // detail.addAll(travelDetailScheduleRepository.findByTsTpEntity(connect.get(i)));
            // }
            // for(int i = 0; i<detail.size(); i++) {
            //     dlist.addAll(travelDetailListRepository.findByTdsEntity(detail.get(i)));
            // }
            // return dlist;

        }
        public ScheduleDeleteVO deleteSchedule(Long tsseq){
            if (tsseq == null ) {
                ScheduleDeleteVO delete = ScheduleDeleteVO.builder().message("없는 여행지입니다..").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
                return delete;
            }
            else{
            ScheduleDeleteVO delete = ScheduleDeleteVO.builder().message("삭제되었습니다.").status(true).code(HttpStatus.OK).build();
            travelScheduleRepository.deleteById(tsseq);
            return delete;
            }
        }


    }

