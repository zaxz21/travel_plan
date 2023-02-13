package com.greenart.travle_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.TravelLikeCountEntity;

public interface TravelLikeCountRepository extends JpaRepository <TravelLikeCountEntity,Long> {
    public TravelLikeCountEntity findByTpSeq(Long tpseq);
    
}
