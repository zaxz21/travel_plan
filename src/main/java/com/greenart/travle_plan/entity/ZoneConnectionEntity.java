package com.greenart.travle_plan.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "zone_connection")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ZoneConnectionEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zc_seq") private Long seq;
    @ManyToOne @JoinColumn(name = "zc_pz_seq" )  ParentZoneEntity parent;
    // @Column(name = "zc_pz_seq") private Long pzSeq;
    @ManyToOne @JoinColumn(name = "zc_cz_seq" )  ChildZoneEntity child;
    // @Column(name = "zc_cz_seq") private Long czSeq;
    
}
