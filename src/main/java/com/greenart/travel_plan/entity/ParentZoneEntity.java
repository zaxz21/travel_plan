package com.greenart.travel_plan.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parent_zone")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentZoneEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pz_seq") private Long pzSeq;
    @Column(name = "pz_name") private String name;
    // @OneToOne(mappedBy = "zc_seq")
    // private Long zcSeq;
}
