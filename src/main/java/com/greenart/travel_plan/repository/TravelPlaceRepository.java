package com.greenart.travel_plan.repository;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.vo.TravelPlaceVO;

public interface TravelPlaceRepository extends JpaRepository <TravelPlaceEntity, Long> {
    public Page<TravelPlaceEntity> findByTpType (Integer tptype,Pageable pageable);
    public Page<TravelPlaceEntity> findByTpNameContains(String keyword, Pageable pageable);
    public static void save(TravelPlaceVO build) {
    }
}
