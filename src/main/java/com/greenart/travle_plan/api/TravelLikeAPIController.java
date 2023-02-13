package com.greenart.travle_plan.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travle_plan.entity.TravelLikeEntity;
import com.greenart.travle_plan.entity.TravelLikeMemberEntity;
import com.greenart.travle_plan.repository.TravelLikeMemberRepository;
import com.greenart.travle_plan.repository.TravelLikeRepository;
import com.greenart.travle_plan.service.TravelLikeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/travel")
@RequiredArgsConstructor
public class TravelLikeAPIController {
    private final TravelLikeService travelLikeService;
    private final TravelLikeRepository travelLikeRepository;
    @Operation(summary = "여행지 좋아요 기능")
      @PutMapping ("/like")
        public ResponseEntity <Object> putTravelLike (
        @Parameter(description = "클릭하는 여행지 번호")  
        @RequestParam Long tpseq,
        @Parameter(description = "로그인한 회원 번호")
        @RequestParam Long miseq) {
            // Map<String, Object> resultMap = memberInfoService.loginAdmin(data);
            // Map<String, Object> map = new LinkedHashMap<String, Object>();
            // if (resultMap == null) {
            //   map.put("status",false);
            //   map.put("message","로그인 후 이용 가능합니다.");
            //   map.put("code",HttpStatus.BAD_REQUEST);
            // }
            // else{
            
            // }
            Map <String, Object> map =  travelLikeService.placeLike(tpseq, miseq);
            return new ResponseEntity<Object>(map, HttpStatus.OK);
  }
  @Operation(summary = "여행지별 좋아요 갯수 출력")
   @GetMapping ("/list")
        public ResponseEntity <Object> getTravelLike (
        @Parameter(description = "여행지별 좋아요 갯수 출력(tpseq:회원 //null일 때는 전체 여행지 좋아요 갯수 조회)")  
        @RequestParam Long tpseq) {
        Map <String, Object> map = travelLikeService.getTravelCount(tpseq);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
     } 
//  travelLikeService.getTravelMember(tpseq, miseq);, @RequestParam Long tpseq, @RequestParam Long miseq
//  List<TravelLikeMemberEntity> map = travelLikeMemberRepository.findAll();

     @GetMapping("/member/like")
      public  ResponseEntity <Object> getMemberLike(@RequestParam Long miseq) {
        List<TravelLikeMemberEntity> map =  travelLikeService.getTravelMember(miseq);
         return new ResponseEntity<Object>(map, HttpStatus.OK);
      }

      @GetMapping("/member")
      public  ResponseEntity <Object> getMember() {
        List<TravelLikeEntity> map = travelLikeRepository.findAll();
         return new ResponseEntity<Object>(map, HttpStatus.OK);
      }

    
}
