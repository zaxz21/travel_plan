package com.greenart.travle_plan.vo.category;

import com.greenart.travle_plan.entity.ZoneConnectionEntity;

import lombok.Data;
@Data
public class ParentZoneVO {
    private Long seq;
    private String name;
    private ChildZoneVO child;

    public ParentZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getParent().getPzSeq();
        this.name = entity.getParent().getName();


        
        // this.child.setSeq(entity.getChild().getSeq());
        // this.child.setName(entity.getChild().getName());
        // this.child.setExplanation(entity.getChild().getExplanation());
        // this.child.setUri(entity.getChild().getIiSeq());
    }

}
