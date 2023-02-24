package com.greenart.travel_plan.vo.category;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class ParentZoneVO {
    @Schema (description = "상위 지역 번호" , example = "1")
    private Long seq;
    @Schema (description = "상위 지역 이름" , example = "서울/경기")
    private String name;
    private ChildZoneVO child;

    public ParentZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getParent().getPzSeq();
        this.name = entity.getParent().getName();
    }
}
