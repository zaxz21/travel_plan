package com.greenart.travel_plan.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.entity.TravelLikeEntity;
import com.greenart.travel_plan.repository.MemberInfoRepository;
import com.greenart.travel_plan.repository.TravelLikeRepository;
import com.greenart.travel_plan.vo.MemberAddReponseVO;
import com.greenart.travel_plan.vo.member.MemberAddVo;
import com.greenart.travel_plan.vo.member.MemberInfoVO;
import com.greenart.travel_plan.vo.member.MemberLoginVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberInfoService {
    private final  MemberInfoRepository memberInfoRepository;
    
     public MemberAddReponseVO addMember(MemberAddVo data) {
        if (data.getMiEmail() == null || data.getMiEmail().equals("")) {
            MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message("이메일을 입력해주세요").code(HttpStatus.BAD_REQUEST).build();
               return add;
        }
        else if(memberInfoRepository.countByMiEmail(data.getMiEmail()) !=0){
            MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message(data.getMiEmail()+"은/는 이미 사용중입니다.").
            code(HttpStatus.BAD_REQUEST).build();
               return add;
        
        }
        else if (data.getMiPwd() == null || data.getMiPwd().equals("")) {
                  MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message("비밀번호를 입력해주세요").
            code(HttpStatus.BAD_REQUEST).build();
               return add;
        }
        else if (data.getMiNickname() == null || data.getMiNickname().equals("")) {
              MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message("이름을 입력해주세요").
            code(HttpStatus.BAD_REQUEST).build();
               return add;
        }
        else {
            MemberInfoEntity entity = MemberInfoEntity.builder().miEmail(data.getMiEmail()).miPwd(data.getMiPwd()).
            miName(data.getMiName()).miNickname(data.getMiNickname()).miPhone(data.getMiPhone()).build();
            memberInfoRepository.save(entity);
            MemberAddReponseVO add = MemberAddReponseVO.builder().status(true).message("회원가입이 완료되었습니다.").
            code(HttpStatus.OK).build();
            return add;
        }

        
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
        public MemberInfoEntity getMemberInfo (Long miseq){
        return memberInfoRepository.findByMiSeq(miseq);
    }

    public MemberAddReponseVO deleteMember (Long miseq) {
     MemberInfoEntity User = memberInfoRepository.findByMiSeq(miseq);
    if(User == null) {
            MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message("해당 회원이 존재하지 않습니다.").
            code(HttpStatus.BAD_REQUEST).build();
            return add;
    }
    else{
        memberInfoRepository.delete(User);
               MemberAddReponseVO add = MemberAddReponseVO.builder().status(false).message("회원탈퇴가 완료되었습니다.").
            code(HttpStatus.OK).build();
            return add;
    }
}
  
    
}
