package com.greenart.travel_plan.vo.like;

import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.vo.member.MemberLikeVO;

import lombok.Data;

@Data
public class TravelLikeVO {
    private Long tlSeq;
    private PlaceLikeVO place;
    private MemberLikeVO member;

    
    public TravelLikeVO (TravelLikeEntity entity) {
        this.tlSeq = entity.getTlSeq();
    }
}
