package com.greenart.travel_plan.vo.category;

import com.greenart.travel_plan.entity.ImgInfoEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;

import lombok.Data;

@Data
public class ChildZoneVO {
    private Long seq;
    private String name;
    private String explanation;
    // private ImageVO image;
    private ImgInfoEntity image;

    public ChildZoneVO(ZoneConnectionEntity entity){
        this.seq = entity.getChild().getSeq();
        this.name = entity.getChild().getName();
        this.explanation = entity.getChild().getExplanation();
        this.image = entity.getChild().getImage();
        // this.uri = entity.getChild().getImage().getIiSeq();
    }
}
