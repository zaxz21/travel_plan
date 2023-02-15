package com.greenart.travel_plan.vo.category;


import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ImgInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddZoneVO {
    // private Long pzSeq;
    private String pzName;
    // private Long czSeq;
    private String czName;
    private String czExplanation;
    // private Long czIiSeq;
    // private ImgInfoEntity image;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
