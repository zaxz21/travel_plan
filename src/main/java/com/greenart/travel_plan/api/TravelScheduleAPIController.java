package com.greenart.travel_plan.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.repository.TravelDetailListRepository;
import com.greenart.travel_plan.service.TravelScheduleService;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.TravelScheduleVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleListVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Tag(name = "일정", description = "일정관련 CRUD")
@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class TravelScheduleAPIController {
    private final TravelScheduleService tsService;
    private final TravelDetailListRepository travelDetailListRepository;

    @Operation(summary = "기본일정 추가하기")
    @PutMapping("/basic")
    public ResponseEntity<MemberAddReponseVO> addBasicScheduleInfo(
    @Parameter(description = "tsStartDate:여행시작날짜/ tsEndDate:여행 종료날짜/ tsName:일정 이름 /miSeq :로그인한 회원의 번호 /tpSeq :회원이 일정에 추가하는 여행지 번호"   )
    @RequestBody BasicScheduleVO data) {
        return new ResponseEntity<>(tsService.addBasicSchedule(data),tsService.addBasicSchedule(data).getCode());
    }
    @Operation(summary = "상세일정 추가하기 / 기본일정에 등록 된 각 일자별 일정 등록")
    @PutMapping("/detail")
    public ResponseEntity<MemberAddReponseVO> addDetailScheduleInfo(
    @Parameter(description = "tsSeq : 상세일정을 추가하는 기본일정 번호 / tpSeq: 해당 날짜에 추가하는 여행지 번호 / data:일정 등록날짜")    
    @RequestBody DetailScheduleVO data) {
        return new ResponseEntity<>(tsService.addDetailSchedule(data) ,tsService.addDetailSchedule(data).getCode());
    }
    @GetMapping("/list")
    public List<TravelDetailListEntity> getList() {
        List <TravelDetailListEntity> list = travelDetailListRepository.findAll();
        System.out.println(list);
        return list;
    }
    
    @Operation(summary = "나의 일정 보기 /로그인 된 회원의 일정 기본정보 보기")
    @GetMapping("/member/list")
    public List<TravelDetailListEntity> getMemberList(
        @Parameter(name = "miseq",description = "로그인 한 회원의 회원 번호")    
        @RequestParam Long miseq) {
        List <TravelDetailListEntity> list = tsService.getMemberSchedule(miseq);
        // System.out.println(list);
        // return new ResponseEntity<>(tsService.getMemberSchedule(miseq) ,HttpStatus.OK);
        return list;
    }



}
