package com.greenart.travel_plan.entity;





import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// @Data
@Getter
@Setter
@Entity
@Table(name = "zone_connection")
// @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZoneConnectionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema  (description = "지역 연결 테이블 번호" ,example = "1" )
    @Column(name = "zc_seq") private Long seq;
    @Schema  (description = "상위 지역" ,example = "서울/경기" )
    @ManyToOne @JoinColumn(name = "zc_pz_seq" )  ParentZoneEntity parent;
    // @Column(name = "zc_pz_seq") private Long pzSeq;
    @Schema  (description = "하위 지역" ,example = "가평" )
    @ManyToOne @JoinColumn(name = "zc_cz_seq" )  ChildZoneEntity child;
    // @Column(name = "zc_cz_seq") private Long czSeq;
    
}
