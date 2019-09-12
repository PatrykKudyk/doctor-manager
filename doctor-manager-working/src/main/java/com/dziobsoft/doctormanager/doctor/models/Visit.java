package com.dziobsoft.doctormanager.doctor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "visitType")
    @Enumerated(value = EnumType.ORDINAL)
    private VisitType visitType;
    @Column(name = "price")
    private Integer price;
}
