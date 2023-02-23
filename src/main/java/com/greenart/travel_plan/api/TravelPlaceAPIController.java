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
    @Parameter(name = "tptype",description = "각 타입 설명(1:명소/2:호텔3:식당)")    
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

     @Operation(summary  = "지역별 여행지 출력")
    @GetMapping("/zone")
    public ResponseEntity<TravelReponseVO> zonePlace(
    @Parameter(name = "tpzcseq",
    description = "1:가평/2:서울/3:수원/4:인천/5:강릉/6:영월/7:춘천/8:대전/9:제천/10:군산/11:남원/12:목포/13:여수/14:전주/15:거제,통영/16:경주/17:대구/18:부산/19:안동/20:울릉도/21:포항/22:제주")    
     Long tpzcseq,
    @Parameter(name = "page", hidden = true)
    @PageableDefault(size=5 ,sort="tpSeq" , direction = Sort.Direction.DESC) Pageable pageable ) {
        return new ResponseEntity<>(travelPlaceService.zonePlace(pageable, tpzcseq),HttpStatus.OK);
    }
    
}
