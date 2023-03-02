package com.greenart.travel_plan.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.greenart.travel_plan.entity.BasicScheduleViewEntity;
import com.greenart.travel_plan.entity.TravelDetailListEntity;
import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.entity.TsTpConnectionEntity;
import com.greenart.travel_plan.repository.BasicScheduleViewReposttory;
import com.greenart.travel_plan.repository.TravelDetailListRepository;
import com.greenart.travel_plan.repository.TsTpConnectionRepository;
import com.greenart.travel_plan.service.TravelScheduleService;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.TravelScheduleVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleListVO;
import com.greenart.travel_plan.vo.schedule.BasicScheduleVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleListVO;
import com.greenart.travel_plan.vo.schedule.DetailScheduleVO;
import com.greenart.travel_plan.vo.schedule.UpdateBasicScheduleVO;
import com.greenart.travel_plan.vo.schedule.ScheduleDeleteVO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "일정", description = "일정관련 CRUD")
@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class TravelScheduleAPIController {
    private final TravelScheduleService tsService;
    private final TravelDetailListRepository travelDetailListRepository;
    private final TsTpConnectionRepository tsTpConnectionRepository;
    private final BasicScheduleViewReposttory baicscheduleviewreposttory;

    @Operation(summary = "기본일정 추가하기")
    @PutMapping("/basic")
    public ResponseEntity<MemberAddReponseVO> addBasicScheduleInfo(
    @Parameter(description = "tsStartDate:여행시작날짜/ tsEndDate:여행 종료날짜/ tsName:일정 이름 /miSeq :로그인한 회원의 번호 /tpSeq :회원이 일정에 추가하는 여행지 번호"   )
    @RequestBody BasicScheduleVO data) {
        MemberAddReponseVO service = tsService.addBasicSchedule(data);
        return new ResponseEntity<>(service, service.getCode());
    }
    @Operation(summary = "상세일정 추가하기 / 기본일정에 등록 된 각 일자별 일정 등록")
    @PutMapping("/detail")
    public ResponseEntity<MemberAddReponseVO> addDetailScheduleInfo(
    @Parameter(description = "tsSeq : 상세일정을 추가하는 기본일정 번호 / tpSeq: 해당 날짜에 추가하는 여행지 번호 / data:일정 등록날짜")    
    @RequestBody DetailScheduleVO data) {
        MemberAddReponseVO service = tsService.addDetailSchedule(data);
        return new ResponseEntity<>(service ,service.getCode());
    }
    // List <TravelDetailListEntity> list = travelDetailListRepository.findAll();
    // System.out.println(list);
    @Operation(summary = "나의 상세일정 보기 /로그인 된 회원의 상세일정 보기")
    @GetMapping("/list")
    public DetailScheduleListVO getList(
    @Parameter(name="tsseq" , description = "상세일정(날짜별) 보기 ")    
    @RequestParam Long tsseq,
    @Parameter(name="miseq" , description = "로그인한 회원의 번호")
    @RequestParam Long miseq) {
        return tsService.getDetailSchedule(tsseq,miseq);
    }
    
    @Operation(summary = "나의 기본 일정 보기 /로그인 된 회원의 기본일정 보기")
    @GetMapping("/member/list")
    public List<BasicScheduleViewEntity> getMemberList(
        @Parameter(name = "miseq",description = "로그인 한 회원의 회원 번호")    
        @RequestParam Long miseq) {
        List <BasicScheduleViewEntity> list = baicscheduleviewreposttory.findByMiSeq(miseq);
        // System.out.println(list);
        // return new ResponseEntity<>(tsService.getMemberSchedule(miseq) ,HttpStatus.OK);
        return list;
    }
    @Operation(summary = "일정 삭제")
    @DeleteMapping("/delete")
    public ScheduleDeleteVO deleteSchedule (
    @Parameter(name = "tsseq" , description= "삭제하려는 일정의 번호")    
    Long tsseq) {
        return   tsService.deleteSchedule(tsseq);
    }

    // @Operation(summary = "기본일정 수정하기")
    // @PostMapping("/basic/update")
    // public ResponseEntity<MemberAddReponseVO> updateBasicScheduleInfo(
    // @Parameter(description = "tsStartDate:여행시작날짜/ tsEndDate:여행 종료날짜/ tsName:일정 이름 /miSeq :로그인한 회원의 번호 /tpSeq :회원이 일정에 추가하는 여행지 번호"   )
    // @RequestBody UpdateBasicScheduleVO data) {
    //     return new ResponseEntity<>(tsService.updateBasicSchedule(data).getCode());
    // }

    @Operation(summary = "기본일정 수정하기")
    @PostMapping("/update/{tsSeq}")
    public ResponseEntity<Object> updateBasicScheduleInfo(
    @Parameter(description = "tsSeq = 여행일정 번호")
    @PathVariable("tsSeq") Long tsSeq,
    @RequestBody UpdateBasicScheduleVO data) {
        Map<String, Object> map = new LinkedHashMap<>();
        UpdateBasicScheduleVO updateSchedule = tsService.updateBasicSchedule(tsSeq, data);
        map.put("message", "일정 수정 완료");
        map.put("data", updateSchedule);
        return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
    }



}
