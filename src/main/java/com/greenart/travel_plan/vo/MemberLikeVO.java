package com.greenart.travle_plan.vo;

import com.greenart.travle_plan.entity.TravelLikeEntity;

import lombok.Data;

@Data
public class MemberLikeVO {
    private Long miSeq;

 public MemberLikeVO (TravelLikeEntity entity) {
    this.miSeq = entity.getMember().getMiSeq();
 }
}
