package com.greenart.travel_plan.vo.category;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ChildZoneEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCateVO {
    private String czName;
    private String czEngName;
    private String czExplanation;
    private Double czLatitude;
    private Double czLongitude;
    private Boolean status;
    private String message;
    private HttpStatus code;
    // public UpdateCateVO(ChildZoneEntity child){
    //     this.czName = child.getName();
    //     this.czExplanation = child.getExplanation();
    // }
}
