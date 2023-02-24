package com.greenart.travel_plan.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.ZoneConnectionEntity;
import com.greenart.travel_plan.repository.ZoneConnectionRepository;
import com.greenart.travel_plan.service.MemberInfoService;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.member.MemberAddVo;
import com.greenart.travel_plan.vo.member.MemberLoginVO;
import com.greenart.travel_plan.vo.member.MemberUpdateVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
// , consumes=MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
@Tag(name = "멤버정보 관리", description = "장르정보 CRUD API")
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberInfoAPIController {
  private final MemberInfoService memberInfoService;
  @Operation(summary = "회원가입")
  @PutMapping(value = "/add") 
  public ResponseEntity<MemberAddReponseVO> putAddMember (
    @Parameter(description = "(miEmail:이메일 / miPwd:비밀번호 / miPhone:전화번호 /miNickname:닉네임 / miName:이름)")
    @RequestBody MemberAddVo data) {
      return new ResponseEntity<>(memberInfoService.addMember(data),HttpStatus.OK);
    }
  @Operation(summary = "로그인")
  @PostMapping(value = "/login")  //로그인
  public ResponseEntity<Object> memberLogin(
    @Parameter(description = "(miEmail:이메일/ miPwd:비밀번호)")
    @RequestBody MemberLoginVO data , HttpSession session) {
    Map<String, Object> resultmap = memberInfoService.loginAdmin(data);
    session.setAttribute("loginUser", resultmap.get("login"));
    System.out.println(session);
  return new ResponseEntity<Object>(resultmap, (HttpStatus)resultmap.get("code"));
  }
  @Operation(summary = "로그아웃")
  @GetMapping("/logout")
  public ResponseEntity<Object> getLogout(
    @Parameter(name= "miseq", description = "로그인한 회원의 miseq를 받아서 해당 회원 로그아웃 처리")  
    Long miseq) {
    Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    resultMap.put("message", "로그아웃 되었습니다.");
    return new ResponseEntity<Object>(resultMap, HttpStatus.OK);
  }

  @Operation(summary = "로그인 한 회원정보 출력")
  @GetMapping(value = "/list") //회원정보 출력
  public ResponseEntity<MemberInfoEntity> getMemberList(
  @Parameter(name= "miseq", description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 출력")  
   @RequestParam Long miseq){
     return new ResponseEntity<>(memberInfoService.getMemberInfo(miseq), HttpStatus.OK);
  }
  @Operation(summary = "로그인 한 회원삭제")
  @DeleteMapping(value = "/delete") // 회원삭제
  public ResponseEntity<MemberAddReponseVO> deleteMember(
  @Parameter(name= "miseq" ,description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 삭제")    
  @RequestParam Long miseq){
     return new ResponseEntity<>(memberInfoService.deleteMember(miseq), HttpStatus.OK);
  }

  // @Operation(summary = "로그인 한 회원삭제")
  // @PatchMapping(value = "/status") // 회원삭제
  // public ResponseEntity<MemberAddReponseVO> statusMember(
  // @Parameter(name= "miseq" ,description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 삭제")    
  // @RequestParam Long miseq){
  //    return new ResponseEntity<>(memberInfoService.deleteMember(miseq), HttpStatus.OK);
  // }

  @Operation(summary = "로그인 한 회원정보 수정")
  @PostMapping(value = "/update") // 회원삭제
  public ResponseEntity<MemberAddReponseVO> updateMember(
  @Parameter(name= "miseq" ,description = "로그인한 회원의 miseq를 받아서 해당 회원의 정보 삭제")    
  @RequestParam Long miseq,
  @RequestBody MemberUpdateVO data){
     return new ResponseEntity<>(memberInfoService.updateMember(data, miseq), HttpStatus.OK);
  }

    
}



