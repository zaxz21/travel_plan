package com.greenart.travel_plan.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.repository.ChildZoneRepository;
import com.greenart.travel_plan.repository.ParentZoneRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.service.category.CategoryService;
import com.greenart.travel_plan.vo.category.AddZoneVO;
import com.greenart.travel_plan.vo.category.AllCateResponseVO;
import com.greenart.travel_plan.vo.category.CateResponseVO;
import com.greenart.travel_plan.vo.category.ParentZoneVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "지역 카테고리", description = "지역 카테고리 조회")
@RestController
@RequestMapping("/api/zone")
public class ZoneAPIController {
    @Autowired ChildZoneRepository czRepo;
    @Autowired ParentZoneRepository pzRepo;
    @Autowired ZoneConnectionRepository zcRepo;
    @Autowired CategoryService cateService;

    // 전체 조회
    @Operation(summary = "전체 지역 조회")
    @GetMapping("/allcate")
    public ResponseEntity<AllCateResponseVO> showAllCate(AllCateResponseVO data){
        return new ResponseEntity<>(cateService.showAllCate(data), HttpStatus.OK);
    }
    // 하위 지역까지 조회
    @Operation(summary = "권역별 여행지 조회")
    @GetMapping("/cate")
    public ResponseEntity<CateResponseVO> showCategory(@Parameter(name = "seq", description = "상위 지역 번호")@RequestParam Long seq){
        // Map<String, Object> resultMap = cateService.showCategory(seq);
        return new ResponseEntity<>(cateService.showCategory(seq), HttpStatus.OK);
        // return new ResponseEntity<Object>(resultMap ,HttpStatus.OK);
    }
    // 지역 추가
    @Operation(summary = "지역 추가")
    @PutMapping("/add")
    public ResponseEntity<AddZoneVO> pupCateAdd(AddZoneVO data){
        return new ResponseEntity<>(cateService.addCategory(data), HttpStatus.OK);
        // Map<String, Object> map = cateService.addCategory(data);
        // return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
