package com.dziobsoft.doctormanager.doctor.api.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
public class PatientResource {

    @JsonProperty
    private String name;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private Date date;
    @JsonProperty
    private String email;

}
