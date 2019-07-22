package com.dziobsoft.doctormanager.doctor.api.assemblers;

import com.dziobsoft.doctormanager.doctor.api.resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.models.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorResourceAssembler {
    public List<DoctorResource> buildResources(List<Doctor> list){

        List<DoctorResource> doctorResources = list.stream().map(doctor -> {
            DoctorResource doctorResource = DoctorResource.builder()
                    .name(doctor.getName())
                    .lastname(doctor.getLastname())
                    .specialization(doctor.getSpecialization())
                    .rate(doctor.getRate())
                    .build();
            return doctorResource;
        }).collect(Collectors.toList());

        return doctorResources;
    }

}