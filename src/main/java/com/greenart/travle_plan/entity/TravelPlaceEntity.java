package com.greenart.travle_plan.entity;

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
@Table(name = "travel_place")
@Entity
@Builder
public class TravelPlaceEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tp_seq") private Long tpSeq;
    @Column(name = "tp_name") private String tpName;
    @Column(name = "tp_adress") private String tpAdress;
    @Column(name = "tp_latitude") private Double tpLatitude;
    @Column(name = "tp_longitude") private Double tpLongitude;
    @Column(name = "tp_zc_seq") private Long tpZcSeq;
    @Column(name = "tp_image") private String tpImage;
    @Column(name = "tp_type") private Integer tpType;
    
}
