package com.greenart.travel_plan.vo.schedule;

import java.time.LocalDate;
import java.util.List;

import com.greenart.travel_plan.entity.BasicScheduleViewEntity;
import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasicScheduleListVO {
    private Long tdlseq;
    // private String place;
    private BasicScheduleViewEntity travel;

    public BasicScheduleListVO (TravelDetailListEntity data) {
        this.tdlseq = data.getTdlSeq();
            // this.img = data.getTdsEntity().getTsTpEntity().getTpEntity().getTpImage();
            // this.place = datas.getTdsEntity().getTsTpEntity().getTpEntity().getTpName();
            // this.name = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsName();
            // this.startDate = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsStartDate();
            // this.endDate = data.getTdsEntity().getTsTpEntity().getTsEntity().getTsEndDate();

    }
}
