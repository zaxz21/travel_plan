package com.greenart.travle_plan.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
@Tag(name = "멤버정보 관리", description = "장르정보 CRUD API")
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoAPIController {
  private final MemberInfoService memberInfoService;
    @Operation(summary = "회원가입")
    @PutMapping(value = "/add", consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<Object> putAddMember (
      @Parameter(description = "multipart/formdata 로 데이터를 입력합니다(miEmail:이메일 / miPwd:비밀번호 / miPhone:전화번호 /miNickname:닉네임 / miName:이름)")
      MemberAddVo data) {
        Map<String, Object>  resultmap = memberInfoService.addMember(data);
        
        return new ResponseEntity<Object>(resultmap,(HttpStatus)resultmap.get("code"));
      }
      @Operation(summary = "로그인")
      @PostMapping(value = "/login", consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)  //로그인
      public ResponseEntity<Object> memberLogin(
        @Parameter(description = "multipart/formdata 로 데이터를 입력합니다(miEmail:이메일/ miPwd:비밀번호)")
        MemberLoginVO data , HttpSession session) {
        Map<String, Object> resultmap = memberInfoService.loginAdmin(data);
        session.setAttribute("loginUser", resultmap.get("login"));
      return new ResponseEntity<Object>(resultmap, (HttpStatus)resultmap.get("code"));
  }
  @Operation(summary = "로그인 한 회원정보 출력")
  @GetMapping(value = "/list") //회원정보 출력
  public ResponseEntity<Object> getMemberList(
  @Parameter(description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 출력")  
  @RequestParam Long miseq){
    MemberInfoEntity member = memberInfoService.getMemberInfo(miseq);
     return new ResponseEntity<Object>(member, HttpStatus.OK);
  }
  @Operation(summary = "로그인 한 회원삭제")
  @DeleteMapping(value = "/delete") // 회원삭제
  public ResponseEntity<Object> deleteMember(
  @Parameter(description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 삭제")    
  @RequestParam Long miseq){
    Map<String, Object> resultMap = memberInfoService.deleteMember(miseq);
     return new ResponseEntity<Object>(resultMap, HttpStatus.OK);
  }

    
}
