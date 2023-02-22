package com.greenart.travel_plan.service;

import org.springframework.stereotype.Service;

import com.greenart.travel_plan.repository.TravelScheduleRepository;
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.vo.TravelScheduleVO;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TravelScheduleService {
    private final TravelScheduleRepository travelScheduleRepository;
    private final MemberInfoRepository memberInfoRepository;
    // 일정 조회
    public List<TravelScheduleVO> getSchedule(Long tsSeq, Long miSeq) {
        MemberInfoEntity member = memberInfoRepository.findByMiSeq(miSeq);
    }
}
