package com.greenart.travel_plan.vo;

import java.time.LocalDate;
import java.util.List;

import com.greenart.travel_plan.entity.ChildZoneEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TravelScheduleVO {
    private Long tsSeq;
    private String tsImg;
    private String tsName;
    private LocalDate startDate;
    private LocalDate endDate;

    private ChildZoneEntity childZoneEntity;
    public TravelScheduleVO(TravelScheduleEntity travelSchedule) {
        this.tsSeq = travelSchedule.getTsSeq();
        this.tsImg = childZoneEntity.getImage().getIiFileName();
        this.tsName = travelSchedule.getTsName();
        this.startDate = travelSchedule.getTsStartDate();
        this.endDate = travelSchedule.getTsEndDate();
    }
}
