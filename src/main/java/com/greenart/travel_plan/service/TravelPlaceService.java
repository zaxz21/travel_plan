package com.greenart.travel_plan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.TravelLikeCountEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.repository.TravelLikeCountRepository;
import com.greenart.travel_plan.repository.TravelPlaceRepository;
import com.greenart.travel_plan.vo.TravelPlaceVO;
import com.greenart.travel_plan.vo.TravelReponseVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelPlaceService {
    private final TravelPlaceRepository travelPlaceRepository;
    private final TravelLikeCountRepository travelLikeCountRepository;
    public TravelReponseVO SearchTravlePlace (String keyword, Pageable pageable) {
        if(keyword == null) {keyword = "";}
        Page<TravelLikeCountEntity> list = travelLikeCountRepository.findByTpNameContains(keyword, pageable);
        TravelReponseVO response = TravelReponseVO.builder().list(list.getContent()).totalPage(list.getTotalPages())
        .total(list.getTotalElements()).currentPage(list.getNumber()).build();
        return response;
    
    }
    public TravelReponseVO SearchTravleType(Pageable pageable, Integer tptype){
        Page<TravelLikeCountEntity> list = travelLikeCountRepository.findByTpType(tptype,pageable);
        
        if(tptype == null ) {
            TravelReponseVO response = TravelReponseVO.builder().message("검색어를 입력해주세요").build();
            return response;
        }
        else{
            TravelReponseVO response = TravelReponseVO.builder().list(list.getContent()).totalPage(list.getTotalPages()).
            total(list.getTotalElements()).currentPage(list.getNumber()).build();
            return response;
        }
    }
     public TravelReponseVO zonePlace(Pageable pageable, Long tpzcseq){
        Page<TravelLikeCountEntity> list = travelLikeCountRepository.findByTpZcSeq(tpzcseq, pageable);
        
             TravelReponseVO response = TravelReponseVO.builder().list(list.getContent()).totalPage(list.getTotalPages()).
             total(list.getTotalElements()).currentPage(list.getNumber()).build();
             return response;
        
    }
    
}
