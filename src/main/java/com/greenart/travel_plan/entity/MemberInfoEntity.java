package com.greenart.travel_plan.entity;
package com.greenart.travel_plan.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member_info")
@Entity
@Builder
@DynamicInsert
public class MemberInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "회원정보 번호" , example = "1")
    @Column(name = "mi_seq") private Long miSeq;
    @Schema(description = "회원 이메일" , example = "sss129@test.com")
    @Column(name = "mi_email") private String miEmail;
    @Schema(description = "회원 비밀번호")
    @Column(name = "mi_pwd") private String miPwd;
    @Schema(description = "회원 전화번호" , example = "11111111111")
    @Column(name = "mi_phone") private String miPhone;
    @Schema(description = "회원 닉네임" , example = "test1")
    @Column(name = "mi_nickname") private String miNickname;
    @Schema(description = "회원 상태" , example = "0.일반 / 1.정지 / 2.탈퇴")
    @Column(name = "mi_status")  @ColumnDefault("0") private Integer miStatus;
    @Schema(description = "카카오 로그인 토큰")
    @Column(name = "mi_kakao") private String miKakao;
    @Schema(description = "구글 로그인 토큰")
    @Column(name = "mi_google") private String miGoogle;
    @Schema(description = "회원 이름" , example = "테스트")
    @Column(name = "mi_name") private String miName;
    
}
