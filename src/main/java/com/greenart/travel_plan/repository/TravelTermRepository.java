package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelTermEntity;

public interface TravelTermRepository extends JpaRepository<TravelTermEntity, Long> {
    
}
