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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "detail_schedule_view")
@Entity
@Immutable
public class DetailScheduleViewEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tdl_seq")  private Long tdlSeq;
    @Column(name = "ts_seq") private Long tsSeq;
    @Column(name = "tds_date") private LocalDate tdsDate;
    @Column(name = "tp_name") private String tpName;
    @Column(name = "tp_adress") private String tpAdress;
    @Column(name = "tp_image") private String tpImage;
    
}
