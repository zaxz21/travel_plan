package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.TravelLikeCountEntity;

public interface TravelLikeCountRepository extends JpaRepository <TravelLikeCountEntity,Long> {
    public List<TravelLikeCountEntity> findByTpSeq(Long tpseq);
    public Page<TravelLikeCountEntity> findByTpType (Integer tptype,Pageable pageable);
    public Page<TravelLikeCountEntity> findByTpNameContains(String keyword, Pageable pageable);
    public Page<TravelLikeCountEntity> findByTpZcSeq(Long tpzcseq, Pageable pageable);
    
    
}
