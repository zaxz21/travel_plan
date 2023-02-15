package com.greenart.travel_plan.vo;

import org.springframework.http.HttpStatus;

import com.greenart.travel_plan.entity.MemberInfoEntity;
import com.greenart.travel_plan.vo.member.MemberInfoVO;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class MemberReponseVO {
    private MemberInfoVO member;
    private Boolean status;
    private String message;
    private HttpStatus code;
}
