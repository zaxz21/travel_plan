package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelLikeCountEntity;

public interface TravelLikeCountRepository extends JpaRepository <TravelLikeCountEntity,Long> {
    public List<TravelLikeCountEntity> findByTpSeq(Long tpseq);
    
    
}
