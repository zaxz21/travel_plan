package com.greenart.travel_plan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zone_connection")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ZoneConnectionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zc_seq") private Long seq;
    @Column(name = "zc_pz_seq") private String pzSeq;
    @Column(name = "zc_cz_seq") private String czSeq;
}
