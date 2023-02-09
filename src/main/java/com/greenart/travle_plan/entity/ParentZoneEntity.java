package com.greenart.travle_plan.entity;


import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parant_zone")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentZoneEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pz_seq") private Long seq;
    @Column(name = "pz_name") private String name;
}
