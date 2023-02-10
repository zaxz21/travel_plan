package com.greenart.travle_plan.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travle_plan.entity.MemberInfoEntity;
import com.greenart.travle_plan.entity.TravelLikeEntity;
import com.greenart.travle_plan.repository.MemberInfoRepository;
import com.greenart.travle_plan.repository.TravelLikeRepository;
import com.greenart.travle_plan.vo.MemberAddVo;
import com.greenart.travle_plan.vo.MemberInfoVO;
import com.greenart.travle_plan.vo.MemberLoginVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final  MemberInfoRepository memberInfoRepository;
    private final  TravelLikeRepository travelLikeRepository;
     public Map<String, Object> addMember(MemberAddVo data) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        if (data.getMiEmail() == null || data.getMiEmail().equals("")) {
            map.put("status", false);
            map.put("message", "아이디를 입력하세요");
            map.put("code",HttpStatus.BAD_REQUEST);
        }
        else if(memberInfoRepository.countByMiEmail(data.getMiEmail()) !=0){
            map.put("status", false);
            map.put("message", data.getMiEmail()+"은/는 이미 사용중입니다.");
            map.put("code",HttpStatus.BAD_REQUEST);
        }
        else if (data.getMiPwd() == null || data.getMiPwd().equals("")) {
            map.put("status", false);
            map.put("message", "비밀번호를 입력하세요");
            map.put("code",HttpStatus.BAD_REQUEST);
        }
        else if (data.getMiNickname() == null || data.getMiNickname().equals("")) {
            map.put("status", false);
            map.put("message", "이름을 입력하세요");
            map.put("code",HttpStatus.BAD_REQUEST);
        }
        else {
            MemberInfoEntity entity = MemberInfoEntity.builder().miEmail(data.getMiEmail()).miPwd(data.getMiPwd()).
            miName(data.getMiName()).miNickname(data.getMiNickname()).miPhone(data.getMiPhone()).build();
            memberInfoRepository.save(entity);
            map.put("status", true);
            map.put("message", "회원가입 완료");
            map.put("code",HttpStatus.ACCEPTED);
        }

        return map;
    }
     public Map<String, Object> loginAdmin(MemberLoginVO login) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        MemberInfoEntity entity = memberInfoRepository.findByMiEmailAndMiPwd(login.getMiEmail(), login.getMiPwd());
        if (entity == null) {
            map.put("status", false);
            map.put("message","아이디 혹은 비밀번호 오류입니다.");
            map.put("code",HttpStatus.BAD_REQUEST);
        }
        else if (entity.getMiStatus() == 1) {
          map.put("status", false);
          map.put("message","이용정지된 관리자 계정입니다..");
          map.put("code",HttpStatus.BAD_REQUEST);
        }
        else if (entity.getMiStatus() == 2) {
        map.put("status", false);
        map.put("message","탈퇴한 계정입니다.");
        map.put("code",HttpStatus.BAD_REQUEST);
        }
        else {
        map.put("status", true);
        map.put("message","로그인 되었습니다.");
        map.put("login", new MemberInfoVO(entity));
        map.put("code",HttpStatus.ACCEPTED);
    }
    return map;
    }
        public MemberInfoEntity getMemberInfo (Long miSeq){
        return memberInfoRepository.findByMiSeq(miSeq);
    }

    public Map<String, Object> deleteMember (Long miseq) {
    Map <String,Object> resultMap = new LinkedHashMap<String,Object>();
     MemberInfoEntity User = memberInfoRepository.findByMiSeq(miseq);
    if(User == null) {
      resultMap.put("status", false);
      resultMap.put("message", "해당 회원이 존재하지 않습니다.");
      resultMap.put("code",HttpStatus.BAD_REQUEST);
    }
    else{
        memberInfoRepository.delete(User);
      resultMap.put("status", true);
      resultMap.put("message", "회원탈퇴가 완료되었습니다.");
      resultMap.put("code",HttpStatus.OK);
    }
    return resultMap;
    }
  
    
}
