package com.greenart.travel_plan.vo.member;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberUpdateVO {
    @Schema(description = "이메일" ,example = "test@test.com")
    private String miEmail;
    @Schema(description = "전화번호" ,example = "11111111111")
    private String miPhone;
    @Schema(description = "닉네임" ,example = "사용자")
    private String miNickname;
    @Schema(description = "이름" ,example = "이름")
    private String miName;
    @Schema(description = "비밀번호" ,example = "123456789")
    private String miPwd;
    

}
