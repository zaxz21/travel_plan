package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.ImgInfoEntity;

public interface ImgInfoRepository extends JpaRepository <ImgInfoEntity, Long> {
    
}
