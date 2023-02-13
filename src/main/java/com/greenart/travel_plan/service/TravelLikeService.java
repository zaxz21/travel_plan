package com.greenart.travel_plan.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.repository.TravelLikeCountRepository;
import com.greenart.travel_plan.repository.TravelLikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelLikeService {
    private final TravelLikeRepository travelLikeRepository;
    private final TravelLikeCountRepository  travelLikeCountRepository;
       public Map<String, Object> placeLike(Long tpseq,Long miseq ){
        Map <String,Object> resultMap = new LinkedHashMap<String, Object>();
        TravelLikeEntity entity = new TravelLikeEntity(null,tpseq,miseq);
        travelLikeRepository.save(entity);
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
       }else{
       resultMap.put("status", true);
       resultMap.put("message","조회에 성공했습니다.");
       resultMap.put("result", travelLikeCountRepository.findByTpSeq(tpseq) );
       }
       return resultMap;

     }
    
}
