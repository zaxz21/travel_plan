package com.greenart.travel_plan.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberLoginVO {
    @Schema(description = "로그인 이메일" ,example = "sss128@test.com")
    private String miEmail;
    @Schema(description = "로그인 비밀번호" ,example = "1234")
    private String miPwd;
    
}
