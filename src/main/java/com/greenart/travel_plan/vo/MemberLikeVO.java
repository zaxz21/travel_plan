package com.greenart.travel_plan.vo;

import com.greenart.travel_plan.entity.TravelLikeEntity;

import lombok.Data;

@Data
public class MemberLikeVO {
    private Long miSeq;

 public MemberLikeVO (TravelLikeEntity entity) {
    this.miSeq = entity.getMember().getMiSeq();
 }
}
