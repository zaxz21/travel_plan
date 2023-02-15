package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.entity.TravelPlaceEntity;

public interface TravelLikeRepository extends JpaRepository<TravelLikeEntity, Long> {
    // List<TravelLikeEntity> findByTlTpSeqAndTlMiSeq(Long tltpseq , Long timiseq);
    public List<TravelLikeEntity> findByMember(MemberInfoEntity miseq);

    public Integer countByTravelAndMember(TravelPlaceEntity travel, MemberInfoEntity member);
}