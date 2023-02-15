package com.greenart.travel_plan.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.repository.ChildZoneRepository;
import com.greenart.travel_plan.repository.ParentZoneRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.service.category.CategoryService;

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

    // 카테 조회
    @Operation(summary = "전체 지역 조회")
    @GetMapping("/allcate")
    public List<ZoneConnectionEntity> selectCategories(){
        List<ZoneConnectionEntity> resultMap = zcRepo.findAll();
        return resultMap;
    }
    
    @Operation(summary = "권역별 여행지 조회")
    @GetMapping("/cate")
    public ResponseEntity<Object> showCategory(@Parameter(name= "seq",description = "상위 지역 번호")@RequestParam Long seq){
        Map<String, Object> resultMap = cateService.showCategory(seq);
        return new ResponseEntity<Object>(resultMap ,HttpStatus.OK);
    }
}
