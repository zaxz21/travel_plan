package com.greenart.travel_plan.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.entity.TravelLikeMemberEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.repository.TravelLikeCountRepository;
import com.greenart.travel_plan.repository.TravelLikeMemberRepository;
import com.greenart.travel_plan.repository.TravelLikeRepository;
import com.greenart.travel_plan.repository.TravelPlaceRepository;
import com.greenart.travel_plan.vo.TravelCountReponseVO;
import com.greenart.travel_plan.vo.like.PlaceLikeVO;
import com.greenart.travel_plan.vo.like.TravelLikePlaceVO;
import com.greenart.travel_plan.vo.like.TravelLikeVO;

import com.greenart.travel_plan.vo.member.MemberLikeVO;
import com.greenart.travel_plan.vo.member.MemberLoginVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelLikeService {
    private final TravelPlaceRepository travelPlaceRepository;
    private final TravelLikeRepository travelLikeRepository;
    private final TravelLikeCountRepository  travelLikeCountRepository;
    private final TravelLikeMemberRepository travelLikeMemberRepository;
    private final MemberInfoRepository memberInfoRepository;
       public TravelCountReponseVO placeLike(Long tpseq,Long miseq){
        TravelPlaceEntity travel = travelPlaceRepository.findById(tpseq).orElse(null);
        if(travel==null){
          TravelCountReponseVO tReponse = TravelCountReponseVO.builder().status(false).message("여행지번호 오류입니다.").code(HttpStatus.BAD_REQUEST).build();
          return tReponse;
        } 
        MemberInfoEntity member = memberInfoRepository.findById(miseq).orElse(null);
        if(member==null){
          TravelCountReponseVO tReponse = TravelCountReponseVO.builder().status(false).message("회원번호 오류입니다.").code(HttpStatus.BAD_REQUEST).build();
          return tReponse;
        } 
        if(travelLikeRepository.countByTravelAndMember(travel, member)>=1){
           TravelCountReponseVO tReponse = TravelCountReponseVO.builder().status(false).message("이미 좋아요한 여행지입니다.").code(HttpStatus.BAD_REQUEST).build();
          return tReponse;
        }
        TravelLikeEntity entity = new TravelLikeEntity(null, travel, member);
        travelLikeRepository.save(entity);
        TravelCountReponseVO tReponse = TravelCountReponseVO.builder().status(true).message("좋아요!").code(HttpStatus.OK).build();
        return tReponse;
     }
     public TravelCountReponseVO getTravelCount(Long tpseq) {
       if(tpseq == null ) {
        TravelCountReponseVO travel = TravelCountReponseVO.builder().status(true).message("조회에 성공했습니다.").code(HttpStatus.OK).
        result(travelLikeCountRepository.findAll()).build();
        return travel;
       }
       else{
            TravelCountReponseVO travel = TravelCountReponseVO.builder().status(true).message("조회에 성공했습니다.").code(HttpStatus.OK).
        result(travelLikeCountRepository.findByTpSeq(tpseq)).build();
        return travel;
       }

     }
     public List<TravelLikeMemberEntity> getTravelMember (Long miseq) {
      List<TravelLikeMemberEntity> list =  travelLikeMemberRepository.findByMiSeq(miseq);
      
      return list;
     }

     public  List<TravelLikeVO>travelLike(Long miseq) {
      MemberInfoEntity member = memberInfoRepository.findById(miseq).get();

       List<TravelLikeEntity> travel = travelLikeRepository.findByMember(member);
       List<TravelLikeVO> result = new ArrayList<>();
       for (TravelLikeEntity t : travel){
        MemberLikeVO m = new MemberLikeVO(t);
        PlaceLikeVO p = new PlaceLikeVO(t);
        TravelLikeVO tr = new TravelLikeVO(t);
        tr.setMember(m);
        tr.setPlace(p);
        result.add(tr);

       }
    
         return result;
     }
    
}
