package com.greenart.travel_plan.entity;


import java.time.LocalDate;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenart.travel_plan.vo.schedule.UpdateBasicScheduleVO;

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
@Table(name="travel_schedule")
public class TravelScheduleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "여행일정 번호",example = "1" )
    @Column(name="ts_seq")  private Long tsSeq;

    @Schema (description = "여행시작일", example = "2023-01-01")
    @Column(name="ts_start_date") private LocalDate tsStartDate;

    @Schema (description = "여행종료일", example = "2023-01-05")
    @Column(name="ts_end_date") private LocalDate tsEndDate;

    @Schema (description = "일정이름", example = "신나는 부산여행")
    @Column(name="ts_name") private String tsName;

    @Schema (description = "회원 seq" )
    @JoinColumn(name="ts_mi_seq")
    @ManyToOne (fetch = FetchType.LAZY)
    MemberInfoEntity memberEntity;

    public void setUpdateSchedule(UpdateBasicScheduleVO data) {
        this.tsName = data.getTsName();
        this.tsStartDate = data.getTsStartDate();
        this.tsEndDate = data.getTsEndDate();
    }
}

// 나의 일정

// 지역사진
// 지역이름
// 여행이름
// 여행일자
// 선택된장소
// 디데이
