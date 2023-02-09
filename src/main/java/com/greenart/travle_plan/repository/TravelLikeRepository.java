package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greenart.travle_plan.entity.TravelLikeEntity;

public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, Long> {
    
}
