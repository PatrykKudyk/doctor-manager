package com.dziobsoft.doctormanager.doctor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "visit")
public class Visit {
    @Column(name = "id")
    @Id
    private Long id;
    @Column(name = "doctorID")
    private Integer doctorID;
    @Column(name = "patientID")
    private Integer patientID;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "visitType")
    @Enumerated(value = EnumType.ORDINAL)
    private VisitType visitType;
    @Column(name = "price")
    private Integer price;
}
