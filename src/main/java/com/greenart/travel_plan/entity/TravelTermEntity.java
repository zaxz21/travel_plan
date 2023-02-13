package com.greenart.travel_plan.entity;


import java.util.Date;

import org.hibernate.annotations.DynamicInsert;

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
@Entity
@Builder
@DynamicInsert
@Table(name="travel_term")
public class TravelTermEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tt_seq")        private Long tsSeq;
    @Column(name="tt_start_date") private Date tsDate;
    @Column(name="tt_end_date")   private Date tsTtSeq;
    @Column(name="tt_mi_seq")     private Long tsTpSeq;
}


