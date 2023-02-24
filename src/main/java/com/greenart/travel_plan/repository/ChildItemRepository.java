package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ChildItemEntity;

public interface ChildItemRepository extends JpaRepository<ChildItemEntity, Long>{
    // public ChildItemEntity findByCiSeq(Long seq);
    Long deleteByCiSeq(Long ciSeq);
    public List<ChildItemEntity> findByCiSeq(Long seq);
    

    
}
