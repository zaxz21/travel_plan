package com.greenart.travel_plan.vo;

import com.greenart.travel_plan.entity.ImgInfoEntity;

import lombok.Data;

@Data
public class ImgListVO {
    private String iiFileName;
    
    public ImgListVO(ImgInfoEntity data) {
        this.iiFileName = data.getIiFileName();
    }
    
}