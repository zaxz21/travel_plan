package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelPlaceEntity;

public interface TravelPlaceRepository extends JpaRepository <TravelPlaceEntity, Long> {
    
}
