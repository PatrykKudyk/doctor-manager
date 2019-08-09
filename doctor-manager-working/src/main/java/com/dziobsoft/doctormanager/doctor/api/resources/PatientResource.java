package com.dziobsoft.doctormanager.doctor.api.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResource {

    @JsonProperty
    private String name;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private LocalDate birthdate;
    @JsonProperty
    private String email;

}
