package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelScheduleEntity;

public interface TravelScheduleRepository extends JpaRepository<TravelScheduleEntity, Long> {
    
}
