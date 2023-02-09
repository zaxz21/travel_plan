package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greenart.travle_plan.entity.TravelTermEntity;

public interface TravelTermRepository extends JpaRepository<TravelTermEntity, Long> {
    
}
