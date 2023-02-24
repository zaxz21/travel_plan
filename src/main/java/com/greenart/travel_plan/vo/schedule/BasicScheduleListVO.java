package com.greenart.travel_plan.vo.schedule;

import java.time.LocalDate;
import java.util.List;

import com.greenart.travel_plan.entity.TravelDetailListEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicScheduleListVO {
    private String img;
    private String place;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String msg;
    

    public BasicScheduleListVO (TravelDetailListEntity data) {
            this.img = data.getTdsEntity().getTsTpEntity().getTpEntity().getTpImage();
            this.place = data.getTdsEntity().getTsTpEntity().getTpEntity().getTpName();
            this.name = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsName();
            this.startDate = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsStartDate();
            this.endDate = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsEndDate();

    }
}
