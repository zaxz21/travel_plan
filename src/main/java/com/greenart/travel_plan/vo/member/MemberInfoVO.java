package com.greenart.travel_plan.vo.member;

import com.greenart.travel_plan.entity.MemberInfoEntity;

import lombok.Data;

@Data
public class MemberInfoVO {

// private Long miSeq;
private String miEmail;
// private String miPwd;
private String miPhone;
private String miNickname;
private Integer miStatus;
private String miName;

public MemberInfoVO(MemberInfoEntity entity) {
// this.miSeq = entity.getMiSeq();
this.miEmail = entity.getMiEmail();
// this.miPwd = entity.getMiPwd();
this.miPhone = entity.getMiPhone();
this.miNickname = entity.getMiNickname();
this.miStatus = entity.getMiStatus();
this.miName = entity.getMiName();

}
    
}
