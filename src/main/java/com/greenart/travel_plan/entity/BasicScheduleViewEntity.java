package com.greenart.travel_plan.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "basic_schedule_view")
@Entity
@Immutable
public class BasicScheduleViewEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ts_seq ") private Long tsSeq;
    @Column(name = "mi_seq") @JsonIgnore private Long miSeq;
    @Column(name = "tp_image") private String tpImage;
    @Column(name = "cz_name") private String czName;
    @Column(name = "ts_name") private String tsName;
    @Column(name = "ts_start_date") private LocalDate tsStartDate;
    @Column(name = "ts_end_date") private LocalDate tsEndDate;
    
    
    
}
