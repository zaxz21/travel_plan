package com.greenart.travel_plan.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.greenart.travel_plan.repository.ChildZoneRepository;
import com.greenart.travel_plan.repository.ParentZoneRepository;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.service.category.CategoryService;
import com.greenart.travel_plan.vo.category.AddZoneVO;
import com.greenart.travel_plan.vo.category.AllCateResponseVO;
import com.greenart.travel_plan.vo.category.CateResponseVO;
import com.greenart.travel_plan.vo.category.DeleteCateVO;
import com.greenart.travel_plan.vo.category.UpdateCateVO;

import io.micrometer.common.lang.Nullable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

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

    @Operation(summary = "지역 검색")
    @GetMapping("/search")
    public ResponseEntity<AllCateResponseVO> searchAllCate(  @Parameter(name = "keyword", description = "지역명") @RequestParam @Nullable String keyword){
        return new ResponseEntity<>(cateService.searchAllCate(keyword)  ,HttpStatus.OK);
    }


    // 하위 지역까지 조회
    @Operation(summary = "권역별 여행지 조회")
    @GetMapping("/cate")
    public ResponseEntity<CateResponseVO> showCategory(@Parameter(name = "seq", description = "상위 지역 번호")@RequestParam Long seq){
        return new ResponseEntity<>(cateService.showCategory(seq), HttpStatus.OK);
    }
    // 지역 추가
    @Operation(summary = "지역 추가")
    @PutMapping("/add")
    public ResponseEntity<AddZoneVO> addCate(@ModelAttribute AddZoneVO data, MultipartFile file){
        return new ResponseEntity<>(cateService.addCategory(data,file), HttpStatus.OK);
        // Map<String, Object> map = cateService.addCategory(data);
        // return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // 수정
    @Operation(summary = "지역 수정")
    @PatchMapping("/update/{type}/{seq}")
    public ResponseEntity<UpdateCateVO> updateCate(UpdateCateVO data, @Parameter(name = "type", description = "상위:pz / 하위: cz") @PathVariable String type, @Parameter(name = "seq", description = "수정할 카테고리 번호") @PathVariable Long seq) {
        return new ResponseEntity<>(cateService.updateCategory(data, seq, type), HttpStatus.OK);
    }

    // 삭제
    @Operation(summary = "지역 삭제")
    @DeleteMapping("/delete/{type}/{seq}")
    public ResponseEntity<DeleteCateVO> deleteCate(DeleteCateVO data, @Parameter(name = "type", description = "상위:pz / 하위: cz") @PathVariable String type, @Parameter(name = "seq", description = "삭제할 카테고리 번호")@PathVariable Long seq){
        return new ResponseEntity<>(cateService.deleteCate(data, seq, type), HttpStatus.OK);
    }
}
