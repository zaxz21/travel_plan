package com.greenart.travel_plan.entity;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
@Table(name="travel_detail_schedule")
public class TravelDetailScheduleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "상세일정 기본키", example = "1" )
    @Column(name="tds_seq") private Long tdsSeq;

    @Schema (description = "날짜" )
    @Column(name="tds_date")
    private LocalDate tdsDate;

    @Schema (description = "일정, 여행지 연결seq" )
    @JoinColumn(name="tds_ttc_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    TsTpConnectionEntity tsTpEntity;
}
