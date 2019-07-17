package com.dziobsoft.doctormanager.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Column(name = "id")
    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "specialization")
    @Enumerated(value = EnumType.ORDINAL)
    private Specialization specialization;
    @Column(name = "rate")
    private int rate;
}
