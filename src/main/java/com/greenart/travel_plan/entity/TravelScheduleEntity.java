package com.greenart.travel_plan.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name="travel_schedule")
public class TravelScheduleEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "여행일정 번호",example = "1" )
    @Column(name="ts_seq") private Long tsSeq;

    @Schema (description = "일정이름", example = "신나는 부산여행")
    @Column(name="ts_name") private String tsName;

    @Schema (description = "여행시작날짜" )
    @Column(name="ts_date") private LocalDateTime tsDate;

    @Schema (description = "여행기간 번호" )
    @JoinColumn(name="ts_tt_seq")
    @OneToOne(fetch = FetchType.LAZY)
    TravelTermEntity travelTerm;
    // private Long tsTtSeq;

    @Schema (description = "여행지 번호" )
    @JoinColumn(name="ts_tp_seq")
    @OneToMany(fetch = FetchType.LAZY)
    TravelPlaceEntity travelPlace;
    
    // private Long tsTpSeq;
}

// 나의 일정

// 지역사진
// 지역이름
// 여행이름
// 여행일자
// 선택된장소
// 디데이
