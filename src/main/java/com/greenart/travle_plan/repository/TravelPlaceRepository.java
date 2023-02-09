package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.TravelPlaceEntity;

public interface TravelPlaceRepository extends JpaRepository <TravelPlaceEntity, Long> {
    
}
