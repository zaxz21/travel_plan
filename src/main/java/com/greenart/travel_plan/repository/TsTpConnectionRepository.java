package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;

public interface TsTpConnectionRepository extends JpaRepository<TsTpConnectionEntity , Long> {
    public TsTpConnectionEntity findByTsEntityAndTpEntity(TravelScheduleEntity travel, TravelPlaceEntity place);
    public List<TsTpConnectionEntity> findByTsEntity(TravelScheduleEntity travel);
    

    
}
