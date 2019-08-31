package com.dziobsoft.doctormanager.doctor.api.resources;


import com.dziobsoft.doctormanager.doctor.models.Doctor;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import com.dziobsoft.doctormanager.doctor.models.VisitType;
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
public class VisitResource {
    @JsonProperty
    private Integer doctorID;
    @JsonProperty
    private Integer patientID;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private Integer duration;
    @JsonProperty
    private VisitType visitType;
    @JsonProperty
    private Integer price;
}
