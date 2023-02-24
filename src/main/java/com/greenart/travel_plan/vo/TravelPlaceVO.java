package com.greenart.travel_plan.vo;

import com.greenart.travel_plan.entity.TravelPlaceEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TravelPlaceVO {
    private Long tpSeq;
    private String tpName;
    private String tpAdress;
    private String tpLatitude;
    private String tpLongitude;
    private Long tpZcSeq;
    private String tpImage;
    private Integer tpType;
    private String tpCate;

    public TravelPlaceVO(TravelPlaceEntity travelPlaceEntity) {
        this.tpSeq = travelPlaceEntity.getTpSeq();
        this.tpName = travelPlaceEntity.getTpName();
        this.tpAdress = travelPlaceEntity.getTpAdress();
        this.tpLatitude = travelPlaceEntity.getTpLatitude();
        this.tpLongitude = travelPlaceEntity.getTpLongitude();
        this.tpZcSeq = travelPlaceEntity.getTpZcSeq();
        this.tpImage = travelPlaceEntity.getTpImage();
        this.tpType = travelPlaceEntity.getTpType();
        this.tpCate = travelPlaceEntity.getTpCate();
    }
}
