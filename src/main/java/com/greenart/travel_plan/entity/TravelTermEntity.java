package com.greenart.travel_plan.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name="travel_term")
public class TravelTermEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema (description = "여행기간 번호", example ="1" )
    @Column(name="tt_seq")        private Long tsSeq;

    @Schema (description = "여행 시작 날짜" )
    @Column(name="tt_start_date") private Date ttStartDate;

    @Schema (description = "여행 끝 날짜" )
    @Column(name="tt_end_date")   private Date ttEndDate;

    @Schema (description = "회원 번호" )
    @JoinColumn(name="tt_mi_seq")     
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberInfoEntity member;

    @Schema (description = "여행일정seq" )
    @OneToOne(mappedBy = "travelTerm")
    private TravelScheduleEntity ttSchedule;
}


