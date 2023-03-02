package com.greenart.travel_plan.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.DetailScheduleViewEntity;
import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TravelDetailScheduleEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;
import com.greenart.travel_plan.repository.BasicScheduleViewReposttory;
import com.greenart.travel_plan.repository.DetailScheduleViewRepostiory;
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.repository.TravelDetailListRepository;
import com.greenart.travel_plan.repository.TravelDetailScheduleRepository;
import com.greenart.travel_plan.repository.TravelPlaceRepository;
import com.greenart.travel_plan.repository.TravelScheduleRepository;
import com.greenart.travel_plan.repository.TsTpConnectionRepository;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleListVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleListVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleVO;
import com.greenart.travel_plan.vo.schedule.UpdateBasicScheduleVO;
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
    private final DetailScheduleViewRepostiory detailScheduleViewRepostiory;
    private final TravelScheduleRepository travelScheduleRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final TravelPlaceRepository travelPlaceRepository;
    private final TsTpConnectionRepository tsTpConnectionRepository;
    private final TravelDetailScheduleRepository travelDetailScheduleRepository;
    private final TravelDetailListRepository travelDetailListRepository;
    private final BasicScheduleViewReposttory basicScheduleViewReposttory;
    //  place.replace(/\r/gi, "\\r").replace(/\n/gi, '\\n').replace(/\t/gi, '\\t').replace(/\f/gi, '\\f');
    // public MemberAddReponseVO addBasicSchedule (BasicScheduleVO data ) {
    //     MemberInfoEntity member = memberInfoRepository.findByMiSeq(data.getMiSeq());
    //     // TravelPlaceEntity place =  travelPlaceRepository.findById(data.getTpSeq()).orElse(null);
    //     List<TravelPlaceEntity> place = new ArrayList<>();
    //     for(Long i : data.getTpSeq()) {
    //         TravelPlaceEntity travel = travelPlaceRepository.findByTpSeq(i);
    //         if(travel==null){
    //             MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("잘못된 여행지 번호가 포함되어있습니다.").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
    //             return reponse;
    //         }
    //         place.add(travel);
    //     }
    //     // List<TravelPlaceEntity> place = travelPlaceRepository.findAllById(data.getTpSeq());
    //     if(member ==  null) {
    //         MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("로그인 후 이용 가능합니다.").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
    //         return reponse;
    //     }
    //     else{
    //         TravelScheduleEntity travel = 
    //         TravelScheduleEntity.builder().tsStartDate(data.getTsStartDate()).tsEndDate(data.getTsEndDate()).tsName(data.getTsName()).memberEntity(member).build();
    //         travelScheduleRepository.save(travel) ;
            
    //         for(int i = 0; i<place.size(); i++) {
    //             TsTpConnectionEntity connect = TsTpConnectionEntity.builder().tsEntity(travel).tpEntity(place.get(i)).build();
    //             tsTpConnectionRepository.save(connect);
    //         }

    //     //    List <TsTpConnectionEntity> connect = TsTpConnectionEntity.builder().tsEntity(travel).tpEntity(place).build();
    //         // 

    //         MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("일정 추가 완료").status(true).code(HttpStatus.OK).build();
    //         return reponse;
    //     }
    // }
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
        List<TravelDetailListEntity> tdlList = new ArrayList<>();
        List <TravelDetailScheduleEntity> tdList = new ArrayList<>();
        List<TsTpConnectionEntity> tstpList = new ArrayList<>();

        TravelScheduleEntity travel = travelScheduleRepository.findById(data.getTsSeq()).orElse(null);
        // TravelPlaceEntity place = travelPlaceRepository.findById(data.getTpSeq().get(0)).orElse(null);
        List<TravelPlaceEntity> tlist = new ArrayList<>();
        for(Long i : data.getTpSeq()){
            TravelPlaceEntity tplace = travelPlaceRepository.findByTpSeq(i);
            if(tplace == null) {
                MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("여행지가 존재하지 않습니다.").status(false).code(HttpStatus.BAD_GATEWAY).build();
                return reponse;
            }
            tlist.add(tplace);
        }
        for(int i = 0 ; i<tlist.size(); i++) {
            TsTpConnectionEntity connect = tsTpConnectionRepository.findByTsEntityAndTpEntity(travel, tlist.get(i));
            if(connect == null){
                MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("일정이 존재하지 않습니다.").status(false).code(HttpStatus.BAD_GATEWAY).build();
                return reponse;
            }
            tstpList.add(connect);
        }
        Boolean sData = travel.getTsStartDate().isBefore(data.getData());
        Boolean eData = travel.getTsEndDate().isAfter(data.getData());
        if(sData == false || eData == false) {
            MemberAddReponseVO reponse = MemberAddReponseVO.builder().message("여행 시작 전 혹은 종료 후 날짜는 입력할 수 없습니다.").status(false).code(HttpStatus.BAD_GATEWAY).build();
            return reponse;
        }
        else{
            for(int i = 0; i<tstpList.size(); i++) {
                TravelDetailScheduleEntity detail = TravelDetailScheduleEntity.builder().tdsDate(data.getData()).tsTpEntity(tstpList.get(i)).build();
                tdList.add(detail);
            }
            travelDetailScheduleRepository.saveAll(tdList);
         for(int i = 0; i<tdList.size(); i++) {
                TravelDetailListEntity dList = TravelDetailListEntity.builder().tdsEntity(tdList.get(i)).build();
                tdlList.add(dList);
            }
        // TravelDetailListEntity dList = TravelDetailListEntity.builder().tdsEntity(detail).build();
        travelDetailListRepository.saveAll(tdlList);
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


        public UpdateBasicScheduleVO updateBasicSchedule(Long tsSeq, UpdateBasicScheduleVO data) {
            TravelScheduleEntity updateSchedule = travelScheduleRepository.findById(tsSeq).orElseThrow();
            updateSchedule.setUpdateSchedule(data);
            travelScheduleRepository.save(updateSchedule);
            return data;
        }

        public ScheduleDeleteVO deleteSchedule(Long tsseq){
            if (tsseq == null ) {
                ScheduleDeleteVO delete = ScheduleDeleteVO.builder().message("존재하지 않는 일정입니다.").status(false).code(HttpStatus.NOT_ACCEPTABLE).build();
                return delete;
            }
            else{
            ScheduleDeleteVO delete = ScheduleDeleteVO.builder().message("삭제되었습니다.").status(true).code(HttpStatus.OK).build();
            travelScheduleRepository.deleteById(tsseq);
            return delete;
            }
        }

        public DetailScheduleListVO getDetailSchedule (Long tsseq ,Long miseq) {
            // List<TravelDetailListEntity> travel = travelDetailListRepository.findAll();
            MemberInfoEntity member = memberInfoRepository.findByMiSeq(miseq);
            TravelScheduleEntity schedule = travelScheduleRepository.findByTsSeqAndMemberEntity(tsseq, member);
            // List<TsTpConnectionEntity> connect = tsTpConnectionRepository.findByTsEntity(schedule);
            // for (int i = 0; i<connect.size(); i++) {
            //     List<TravelDetailScheduleEntity> detail =  travelDetailScheduleRepository.findByTsTpEntity(connect.get(i));
            // }
            if(schedule == null) {
                 DetailScheduleListVO detail =  DetailScheduleListVO.builder().code(HttpStatus.BAD_GATEWAY).message("존재하지 않는 일정입니다.").status(false).build();
                 return detail;
            }
            DetailScheduleListVO detail =  DetailScheduleListVO.builder().tsseq(schedule.getTsSeq()).
            tsname(schedule.getTsName()).dlist(detailScheduleViewRepostiory.findByTsSeq(tsseq)).message("조회에 성공했습니다.").code(HttpStatus.OK).status(true).build();
            // for(int i=0; i<travel.size(); i++) {
            // }
            return detail;

        }

}

