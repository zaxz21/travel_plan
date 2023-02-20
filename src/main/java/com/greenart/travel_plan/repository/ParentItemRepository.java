package com.greenart.travel_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ParentItemEntity;

public interface ParentItemRepository extends JpaRepository<ParentItemEntity, Long>{
    
}
