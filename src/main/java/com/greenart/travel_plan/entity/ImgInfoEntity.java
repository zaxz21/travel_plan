package com.greenart.travel_plan.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "img_info")
@Entity
@Builder
public class ImgInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "이미지 번호" , example = "1")
    @Column(name = "ii_seq") private Long iiSeq;
    @Schema(description = "이미지 파일 이름", example = "대구야경")
    @Column(name = "ii_file_name") private String iiFileName;
    
}
