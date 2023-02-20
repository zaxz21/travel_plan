package com.greenart.travel_plan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "child_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChildItemEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "하위 준비물 번호" , example = "1")
    @Column(name = "ci_seq")    private Long   ciSeq;
    @Schema(description = "하위 준비물 이름" , example = "칫솔/치약")
    @Column(name = "ci_name")   private String ciName;
}
