package com.greenart.travel_plan.vo.like;

import com.greenart.travel_plan.entity.TravelLikeEntity;

import lombok.Data;
@Data
public class PlaceLikeVO {
private Long tpSeq;
private String tpName;
private String tpImage;

public PlaceLikeVO(TravelLikeEntity entity){
this.tpSeq = entity.getTravel().getTpSeq();
this.tpName = entity.getTravel().getTpName();
this.tpImage = entity.getTravel().getTpImage();
    
}

    
}
