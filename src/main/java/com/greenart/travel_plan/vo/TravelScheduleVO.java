package com.greenart.travel_plan.vo;

import java.time.LocalDateTime;
import java.util.Date;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.entity.TravelTermEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TravelScheduleVO {
    private Long tsSeq;
    private String tsName;
    private LocalDateTime tsDate;
    private Date startDate;
    private Date endDate;
    private String placeName;

    public TravelScheduleVO(TravelScheduleEntity entity) {
        this.tsSeq = entity.getTsSeq();
        this.tsName = entity.getTsName();
        this.tsDate = entity.getTsDate();
        this.startDate = entity.getTravelTerm().getTtStartDate();
        this.endDate = entity.getTravelTerm().getTtEndDate();
        this.placeName = entity.getTravelPlace().getTpName();
    }

    // TravelTermEntity travelTerm;
    // TravelPlaceEntity travelPlace;

    // private 
}
