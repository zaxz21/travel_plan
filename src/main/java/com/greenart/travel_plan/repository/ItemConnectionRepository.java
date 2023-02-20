package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.ItemConnectionEntity;
import com.greenart.travel_plan.entity.ParentItemEntity;

public interface ItemConnectionRepository extends JpaRepository<ItemConnectionEntity, Long>{
    List<ItemConnectionEntity> findByPitem(ParentItemEntity pitem);
}
