package com.dziobsoft.doctormanager.doctor.api.resources;

import com.dziobsoft.doctormanager.doctor.models.Specialization;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class DoctorResource {
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private Specialization specialization;
    @JsonProperty
    private int rate;
}