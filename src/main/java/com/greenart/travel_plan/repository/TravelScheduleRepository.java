package com.greenart.travel_plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.vo.schedule.UpdateBasicScheduleVO;

public interface TravelScheduleRepository extends JpaRepository<TravelScheduleEntity, Long> {
    // public TravelScheduleEntity findByMemberEntity(MemberInfoEntity member);
    public TravelScheduleEntity findByTsSeqAndMemberEntity(Long tsseq, MemberInfoEntity member);
    public List<TravelScheduleEntity> findByMemberEntity(MemberInfoEntity member);

    // public void saveAll(UpdateBasicScheduleVO data);
    
}
