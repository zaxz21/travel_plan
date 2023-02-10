package com.greenart.travle_plan.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

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
    @Column(name = "mi_seq") private Long miSeq;
    @Column(name = "mi_email") private String miEmail;
    @Column(name = "mi_pwd") private String miPwd;
    @Column(name = "mi_phone") private String miPhone;
    @Column(name = "mi_nickname") private String miNickname;
    @Column(name = "mi_status")  @ColumnDefault("0") private Integer miStatus;
    @Column(name = "mi_kakao") private String miKakao;
    @Column(name = "mi_google") private String miGoogle;
    @Column(name = "mi_name") private String miName;
    
}
