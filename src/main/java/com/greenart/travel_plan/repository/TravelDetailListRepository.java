package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TravelDetailScheduleEntity;

public interface TravelDetailListRepository extends JpaRepository<TravelDetailListEntity,Long> {
 public List<TravelDetailListEntity> findByTdsEntity  (TravelDetailScheduleEntity detail);
}
