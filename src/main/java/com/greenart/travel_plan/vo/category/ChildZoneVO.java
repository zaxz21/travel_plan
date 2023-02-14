package com.greenart.travel_plan.vo.category;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import lombok.Data;

@Data
public class ChildZoneVO {
    private Long seq;
    private String name;
    private String explanation;
    private String uri;

    public ChildZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getChild().getSeq();
        this.name = entity.getChild().getName();
        this.explanation = entity.getChild().getExplanation();
        this.uri = entity.getChild().getIiSeq();
    }
}
