package com.greenart.travle_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.greenart.travle_plan.entity.TravelLikeMemberEntity;

public interface TravelLikeMemberRepository extends JpaRepository<TravelLikeMemberEntity,Long> {
    public List <TravelLikeMemberEntity> findByMiSeq(Long miseq);
}
