package com.greenart.travel_plan.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.TravelScheduleEntity;
import com.greenart.travel_plan.service.TravelScheduleService;
import com.greenart.travel_plan.vo.TravelScheduleVO;

import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Tag(name = "일정")
@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class TravelScheduleAPIController {
    private final TravelScheduleService tsService;

    @Operation(summary = "일정 불러오기")
    @ApiResponse(responseCode = "200" , description = "일정추가")
    @ApiResponse(responseCode = "403" , description = "로그인 되지 않은 유저가 접근시")
    @GetMapping("")
    public ResponseEntity<TravelScheduleEntity<List<TravelScheduleVO>>> getScheduleInfo() {
        return new ResponseEntity<>(
                new CartinfoResponseBody<>(true, null, tsService.getScheduleInfo(userSeq)), 
                HttpStatus.OK
            );
    }

}
