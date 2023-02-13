package com.greenart.travle_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travle_plan.entity.MemberInfoEntity;
import com.greenart.travle_plan.entity.TravelLikeEntity;

public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, Long> {
    // List<TravelLikeEntity> findByTlTpSeqAndTlMiSeq(Long tltpseq , Long timiseq);
    public List<TravelLikeEntity> findByMember(MemberInfoEntity miseq);
}