package com.greenart.travle_plan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "child_zone")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChildZoneEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cz_seq") private Long seq;
    @Column(name = "cz_name") private String name;
    @Column(name = "cz_explanation") private String explanation;
    @Column(name = "cz_ii_seq") private String iiSeq;
}
