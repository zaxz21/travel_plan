package com.greenart.travel_plan.vo.category;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.ChildZoneEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateCateVO {
    @Schema (description = "수정할 상위 지역 이름" , example = "서울/경기")
    private String pzName;
    @Schema (description = "수정할 지역 이름" , example = "가평")
    private String czName;
    @Schema (description = "수정할 지역 영문명" , example = "GAPYEONG")
    private String czEngName;
    @Schema (description = "수정할 지역 설명" , example = "수정 설명")
    private String czExplanation;
    // @Schema (description = "수정할 지역 위도" , example = "수정 위도")
    // private Double czLatitude;
    // @Schema (description = "수정할 지역 경도" , example = "수정 경도")
    // private Double czLongitude;
    private Boolean status;
    private String message;
    private HttpStatus code;
    // public UpdateCateVO(ChildZoneEntity child){
    //     this.czName = child.getName();
    //     this.czExplanation = child.getExplanation();
    // }
}
