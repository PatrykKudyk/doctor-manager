package com.dziobsoft.doctormanager.doctor.api.assemblers;

import com.dziobsoft.doctormanager.doctor.api.resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.models.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorResourceAssembler {
    public List<DoctorResource> buildResources(List<Doctor> list){
        List<DoctorResource> doctors = new ArrayList<>();
        for (Doctor doctor : list) {
            DoctorResource doctorResource = DoctorResource.builder()
                    .name(doctor.getName())
                    .lastname(doctor.getLastname())
                    .specialization(doctor.getSpecialization())
                    .rate(doctor.getRate())
                    .build();
            doctors.add(doctorResource);
        }
        return doctors;
    }

}