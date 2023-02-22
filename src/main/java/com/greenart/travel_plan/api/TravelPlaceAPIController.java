package com.greenart.travel_plan.api;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.TravelPlaceEntity;
import com.greenart.travel_plan.service.TravelPlaceService;
import com.greenart.travel_plan.vo.TravelReponseVO;

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
    @GetMapping("/place/type")
    public ResponseEntity<TravelReponseVO> getPlace(
    @Parameter(name = "tptype",description = "각 타입 설명(1:식당 / 2:명소 / 3:숙박시설)")    
    Integer tptype,
    @Parameter(name = "pageable",hidden = true)
    @PageableDefault(size=5 ,sort="tpSeq" , direction = Sort.Direction.DESC) Pageable pageable ) {
        return new ResponseEntity<>(travelPlaceService.SearchTravleType(pageable,tptype),HttpStatus.OK);
    }
    @Operation(summary  = "여행지 검색기능")
    @GetMapping("/place")
    public ResponseEntity<TravelReponseVO> getPlace(
    @Parameter(name = "keyword",description = "여행지명 // null 경우에는 전체 여행지 검색")    
    @Nullable String keyword,
    @Parameter(name = "pageable", hidden = true)
    @PageableDefault(size=5 ,sort="likeplace" , direction = Sort.Direction.DESC) Pageable pageable ) {
        return new ResponseEntity<>(travelPlaceService.SearchTravlePlace(keyword,pageable),HttpStatus.OK);
    }
    
}
