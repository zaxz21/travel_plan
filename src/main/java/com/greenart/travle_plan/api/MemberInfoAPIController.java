package com.greenart.travle_plan.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travle_plan.entity.MemberInfoEntity;
import com.greenart.travle_plan.entity.ZoneConnectionEntity;
import com.greenart.travle_plan.repository.ZoneConnectionRepository;
import com.greenart.travle_plan.service.MemberInfoService;
import com.greenart.travle_plan.vo.MemberAddVo;
import com.greenart.travle_plan.vo.MemberLoginVO;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoAPIController {
  private final MemberInfoService memberInfoService;
  
    @PutMapping("/add") //회원가입
    public ResponseEntity<Object> putAddMember (@RequestBody MemberAddVo data) {
        Map<String, Object>  resultmap = memberInfoService.addMember(data);
        
        return new ResponseEntity<Object>(resultmap,(HttpStatus)resultmap.get("code"));
    }
    @PostMapping("/login") //로그인
    public ResponseEntity<Object> memberLogin(@RequestBody MemberLoginVO data) {
    Map<String, Object> resultMap = memberInfoService.loginAdmin(data);
    return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
  }
  @GetMapping("/list")
  public ResponseEntity<Object> getMemberList(@RequestParam Long miseq){
    MemberInfoEntity member = memberInfoService.getMemberInfo(miseq);
     return new ResponseEntity<Object>(member, HttpStatus.OK);
  }
   @DeleteMapping("/delete")
  public ResponseEntity<Object> deleteMember(@RequestParam Long miseq){
    Map<String, Object> resultMap = memberInfoService.deleteMember(miseq);
     return new ResponseEntity<Object>(resultMap, HttpStatus.OK);
  }

    
}
