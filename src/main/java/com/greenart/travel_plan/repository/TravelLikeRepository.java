package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelLikeEntity;

public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, Long> {
    
}
