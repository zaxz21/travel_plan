package com.greenart.travel_plan.entity;

import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@DynamicInsert
@Table(name="ts_tp_connection")
public class TsTpConnectionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "일정, 여행지 연결테이블 기본키", example = "1" )
    @Column(name="ttc_seq") private Long ttcSeq;

    @Schema (description = "일정seq" )
    @JoinColumn(name="ttc_ts_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    TravelScheduleEntity tsEntity;

    @Schema (description = "여행지seq" )
    @JoinColumn(name="ttc_tp_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    TravelPlaceEntity tpEntity;
    
}
