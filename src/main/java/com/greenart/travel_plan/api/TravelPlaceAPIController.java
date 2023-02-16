package com.greenart.travel_plan.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.service.TravelPlaceService;

import io.micrometer.common.lang.Nullable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
@Tag(name = "여행지 조회" ,description= "전체/타입별 여행지 조회")
@RestController
@RequestMapping("/api/travle")
@RequiredArgsConstructor
public class TravelPlaceAPIController {
    private final TravelPlaceService travelPlaceService;
    @Operation(summary  = "타입 별 여행지 조회")
    @GetMapping("/place")
    public List<TravelPlaceEntity> getPlace(
    @Parameter(name = "tptype",description = "각 타입 설명(1:명소/2:호텔3:식당) //null경우 전체 여행지 출력 ")    
    @Nullable Integer tptype) {
        List<TravelPlaceEntity> list = travelPlaceService.getTravlePlace(tptype);
        return list;
    }
    
}
