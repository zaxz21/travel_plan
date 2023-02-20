package com.greenart.travel_plan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "item_connection")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemConnectionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "준비물 연결 테이블 번호" , example = "1")
    @Column(name = "ic_seq")    private Long icSeq;
    @Schema(description = "상위 준비물 이름" , example = "세면/화장품")
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "ic_pi_seq" )  ParentItemEntity pitem;
    // @Column(name = "ic_pi_seq") private Long icPiseq;
    @Schema(description = "하위 준비물 이름" , example = "칫솔/치약")
    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "ic_ci_seq" )  ChildItemEntity citem;
    // @Column(name = "ic_ci_seq") private Long icCiseq;
}
