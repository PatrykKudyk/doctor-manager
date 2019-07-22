package com.dziobsoft.doctormanager.doctor.api.assemblers;


import com.dziobsoft.doctormanager.doctor.api.resources.PatientResource;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientResourceAssembler {

    public List<PatientResource> buildResources(List<Patient> list){

        List<PatientResource> patientResources = list.stream().map(patient -> {
            PatientResource patientResource = PatientResource.builder()
                    .name(patient.getName())
                    .lastname(patient.getLastname())
                    .date(patient.getDate())
                    .email(patient.getEmail())
                    .build();
            return patientResource;
        }).collect(Collectors.toList());

        return patientResources;
    }
}
