package com.greenart.travel_plan.vo.category;


import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ImgInfoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema (description = "상위 지역 이름" , example = "서울/경기")
    private String pzName;
    // private Long czSeq;
    @Schema (description = "하위 지역 이름" , example = "가평")
    private String czName;
    @Schema (description = "하위 지역 설명" , example = "하위 지역 설명")
    private String czExplanation;
    @Schema (description = "영문명" , example = "GAPYEONG")
    private String czEngname;
    @Schema (description = "위도" , example = "위도")
    private Double czLatitude;
    @Schema (description = "경도" , example = "경도")
    private Double czLongitude;
    // private Long czIiSeq;
    // private ImgInfoEntity image;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
