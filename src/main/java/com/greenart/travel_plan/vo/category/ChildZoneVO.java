package com.greenart.travel_plan.vo.category;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ChildZoneVO {
    @Schema (description = "하위 지역 번호" , example = "1")
    private Long seq;
    @Schema (description = "하위 지역 이름" , example = "가평")
    private String name;
    @Schema (description = "영문명" , example = "GAPYEONG")
    private String engname;
    @Schema (description = "위도" , example = "위도")
    private Double latitude;
    @Schema (description = "경도" , example = "경도")
    private Double longitude;
    @Schema (description = "설명" , example = "여행 지역 설명")
    private String explanation;
    // private ImageVO image;
    private ImgInfoEntity image;

    public ChildZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getChild().getSeq();
        this.name = entity.getChild().getName();
        this.engname = entity.getChild().getEngname();
        this.latitude = entity.getChild().getLatitude();
        this.longitude = entity.getChild().getLongitude();
        this.explanation = entity.getChild().getExplanation();
        this.image = entity.getChild().getImage();
        // this.uri = entity.getChild().getImage().getIiSeq();
    }
}
