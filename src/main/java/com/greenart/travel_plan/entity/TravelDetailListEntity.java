package com.greenart.travel_plan.entity;

import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@DynamicInsert
@Table(name="travel_detail_list")
public class TravelDetailListEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "상세일정-목록테이블 기본키", example = "1" )
    @Column(name="tdl_seq") private Long tdlSeq;

    @Schema (description = "상세일정seq" )
    @JoinColumn(name="tdl_seq")
    @OneToOne(fetch = FetchType.LAZY)
    TravelDetailScheduleEntity tdsEntity;
}
