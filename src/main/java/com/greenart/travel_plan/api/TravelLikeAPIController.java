package com.greenart.travel_plan.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.service.TravelLikeService;
import com.greenart.travel_plan.entity.TravelLikeMemberEntity;
import com.greenart.travel_plan.repository.TravelLikeRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
@Tag(name = "여행지 좋아요", description = "여행지 좋아요 관련 API")
@RestController
@RequestMapping("/api/travel")
@RequiredArgsConstructor  
public class TravelLikeAPIController {
    private final TravelLikeService travelLikeService;
    private final TravelLikeRepository  travelLikeRepository;
    @Operation(summary = "여행지 좋아요 기능")
      @PutMapping ("/like")
        public ResponseEntity <Object> putTravelLike (
        @Parameter(name = "tpseq",description = "클릭하는 여행지 번호")  
        @RequestParam Long tpseq,
        @Parameter(name = "miseq",description = "로그인한 회원 번호")
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
        @Parameter(name = "tpseq",description = "여행지별 좋아요 갯수 출력(tpseq:여행지 번호//null일 때는 전체 여행지 좋아요 갯수 조회)")  
        @RequestParam  @Nullable Long tpseq) {
        Map <String, Object> map = travelLikeService.getTravelCount(tpseq);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
     } 
//  travelLikeService.getTravelMember(tpseq, miseq);, @RequestParam Long tpseq, @RequestParam Long miseq
//  List<TravelLikeMemberEntity> map = travelLikeMemberRepository.findAll();

    //  @GetMapping("/like/list")
    //   public  ResponseEntity <Object> getMemberLike(@RequestParam Long miseq) {
    //     List<TravelLikeMemberEntity> map =  travelLikeService.getTravelMember(miseq);
    //      return new ResponseEntity<Object>(map, HttpStatus.OK);
    //   }

      @GetMapping("/member")
      public  ResponseEntity <Object> getMember() {
        List<TravelLikeEntity> map = travelLikeRepository.findAll();
         return new ResponseEntity<Object>(map, HttpStatus.OK);
      }

       @Operation(summary = "회원 별 좋아요한 여행지 출력")
       @GetMapping("/member/like")
        public ResponseEntity<Object> getLikeMember(
        @Parameter(name = "miseq",description = "회원 별 좋아요한 여행지 출력(miseq:회원 번호)")  
        @RequestParam Long miseq){
        Map<String, Object> resultMap = travelLikeService.travelLike(miseq);
        return new ResponseEntity<Object>(resultMap ,HttpStatus.OK);
    }
    
}
