package com.dziobsoft.doctormanager.doctor.API.Resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoctorResource {
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastname;

    public DoctorResource(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}