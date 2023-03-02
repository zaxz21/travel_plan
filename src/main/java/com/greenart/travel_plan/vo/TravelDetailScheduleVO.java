package com.greenart.travel_plan.vo;

import java.time.LocalDate;
import java.util.List;

import com.greenart.travel_plan.entity.ChildZoneEntity;
import com.greenart.travel_plan.entity.TravelDetailScheduleEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TravelDetailScheduleVO {
    private String travelName;
    private LocalDate travelDate;
    private String placeName;

    public TravelDetailScheduleVO(TravelDetailScheduleEntity travelDetailScheduleEntity) {
        this.travelName = travelDetailScheduleEntity.getTsTpEntity().getTsEntity().getTsName();
        this.travelDate = travelDetailScheduleEntity.getTdsDate();
        // this.placeName = travelDetailScheduleEntity.getTsTpEntity().getTpEntity().getTpName();
    }
}
