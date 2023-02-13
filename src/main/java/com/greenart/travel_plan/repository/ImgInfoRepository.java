package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ImgInfoEntity;

public interface ImgInfoRepository extends JpaRepository <ImgInfoEntity, Long> {
    
}
