package com.greenart.travel_plan.entity;




import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "parent_zone")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentZoneEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "상위지역 번호" , example = "1")
    @Column(name = "pz_seq") private Long pzSeq;
    @Schema(description = "상위지역 이름" , example = "서울")
    @Column(name = "pz_name") private String name;
    // @OneToMany(cascade =CascadeType.ALL, mappedBy = "parent")
    // private List<ZoneConnectionEntity> zone;
    // @OneToOne(mappedBy = "zc_seq")
    // private Long zcSeq;
}
