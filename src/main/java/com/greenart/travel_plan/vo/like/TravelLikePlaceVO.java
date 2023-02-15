package com.greenart.travel_plan.vo.like;

import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;

import lombok.Data;
@Data
public class TravelLikePlaceVO {
    private Long tpSeq;
    private Long miSeq;

    public TravelLikePlaceVO (TravelLikeEntity entity) {
        this.tpSeq= entity.getTravel().getTpSeq();
        this.miSeq= entity.getMember().getMiSeq();
      }
}
