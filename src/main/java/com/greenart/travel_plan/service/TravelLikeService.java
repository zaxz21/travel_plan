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
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.repository.TravelLikeCountRepository;
import com.greenart.travel_plan.repository.TravelLikeMemberRepository;
import com.greenart.travel_plan.repository.TravelLikeRepository;
import com.greenart.travel_plan.vo.PlaceLikeVO;
import com.greenart.travel_plan.vo.TravelLikeVO;
import com.greenart.travel_plan.vo.member.MemberLikeVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelLikeService {
    private final TravelLikeRepository travelLikeRepository;
    private final TravelLikeCountRepository  travelLikeCountRepository;
    private final TravelLikeMemberRepository travelLikeMemberRepository;
    private final MemberInfoRepository memberInfoRepository;
       public Map<String, Object> placeLike(Long tpseq,Long miseq ){
        Map <String,Object> resultMap = new LinkedHashMap<String, Object>();
        // TravelLikeEntity entity = new TravelLikeEntity(null,tpseq,miseq);
        // travelLikeRepository.save(entity);
        resultMap.put("status", true);
        resultMap.put("message", "좋습니다.");
        resultMap.put("code",HttpStatus.OK);
        return resultMap;
     }
     public Map<String, Object> getTravelCount(Long tpseq) {
       Map <String,Object> resultMap = new LinkedHashMap<String, Object>();
       if(tpseq == null ) {
        resultMap.put("status", true);
       resultMap.put("message","조회에 성공했습니다.");
       resultMap.put("result", travelLikeCountRepository.findAll() );
       }
       else{
       resultMap.put("status", true);
       resultMap.put("message","조회에 성공했습니다.");
       resultMap.put("result", travelLikeCountRepository.findByTpSeq(tpseq) );
       }
       return resultMap;

     }
     public List<TravelLikeMemberEntity> getTravelMember (Long miseq) {
      List<TravelLikeMemberEntity> list =  travelLikeMemberRepository.findByMiSeq(miseq);
      
      return list;
     }

     public Map<String, Object> travelLike(Long miseq) {
      Map <String,Object> resultmap = new LinkedHashMap<String,Object>();
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
       resultmap.put("data", result);
         return resultmap;
     }
    
}
