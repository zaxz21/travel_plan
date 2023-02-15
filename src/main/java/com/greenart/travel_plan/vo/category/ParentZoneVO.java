package com.greenart.travel_plan.vo.category;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import lombok.Data;
@Data
public class ParentZoneVO {
    private Long seq;
    private String name;
    private ChildZoneVO child;

    public ParentZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getParent().getPzSeq();
        this.name = entity.getParent().getName();
    }
}
