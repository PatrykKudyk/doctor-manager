package com.dziobsoft.doctormanager.doctor.API.Resources;

import com.dziobsoft.doctormanager.doctor.Models.Specialization;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorResource {
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private Specialization specialization;
    @JsonProperty
    private int rate;

    public DoctorResource(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public DoctorResource(String name, String lastname, Specialization specialization, int rate){
        this.name = name;
        this.lastname = lastname;
        this.specialization = specialization;
        this.rate = rate;
    }
}