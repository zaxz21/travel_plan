package com.greenart.travel_plan.api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.service.TravelLikeService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/travel")
@RequiredArgsConstructor
public class TravelLikeAPIController {
    private final TravelLikeService travelLikeService;
      @PutMapping ("/like")
        public ResponseEntity <Object> putTravelLike ( @RequestParam Long tpseq,@RequestParam Long miseq) {
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
   @GetMapping ("/list")
        public ResponseEntity <Object> getTravelLike (Long miseq) {
        Map <String, Object> map = travelLikeService.getTravelCount(miseq);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
     }

    
}
