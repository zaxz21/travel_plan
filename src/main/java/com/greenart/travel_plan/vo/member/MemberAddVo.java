package com.greenart.travel_plan.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberAddVo {
    @Schema (description = "회원 이메일" , example = "sss129@test.com")
    private String miEmail;
    @Schema(description = "회원 비밀번호")
    private String miPwd;
    @Schema(description = "회원 전화번호" , example = "11111111111")
    private String miPhone;
    @Schema(description = "회원 닉네임" , example = "test1")
    private String miNickname;
    @Schema(description = "회원 이름" , example = "테스트")
    private String miName;
    
}
