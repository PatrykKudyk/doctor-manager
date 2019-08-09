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
                    .birthdate(patient.getBirthdate())
                    .email(patient.getEmail())
                    .build();
            return patientResource;
        }).collect(Collectors.toList());

        return patientResources;
    }

    public Patient buildPatient(PatientResource patientResource){

        Patient patient = Patient.builder()
                .name(patientResource.getName())
                .lastname(patientResource.getLastname())
                .birthdate(patientResource.getBirthdate())
                .email(patientResource.getEmail())
                .build();

        return patient;
    }

    public Patient updatePatient(PatientResource patientResource, Patient patient){

        if(patientResource.getName() != null){
            patient.setName(patientResource.getName());
        }
        if(patientResource.getLastname() != null){
            patient.setLastname(patientResource.getLastname());
        }
        if(patientResource.getBirthdate() != null){
            patient.setBirthdate(patientResource.getBirthdate());
        }
        if(patientResource.getEmail() != null){
            patient.setEmail(patientResource.getEmail());
        }

        return patient;
    }
}
