package com.greenart.travel_plan.vo;

import com.greenart.travel_plan.vo.member.MemberLikeVO;

import lombok.Data;

@Data
public class TravelLikeVO {
    private Long tlSeq;
    private PlaceLikeVO place;
    private MemberLikeVO member;

    
}
