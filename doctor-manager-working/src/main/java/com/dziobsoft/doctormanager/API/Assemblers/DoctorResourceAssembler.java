package com.dziobsoft.doctormanager.API.Assemblers;

import com.dziobsoft.doctormanager.API.Resources.DoctorResource;
import com.dziobsoft.doctormanager.Models.Doctor;

import java.util.List;

public class DoctorResourceAssembler {
    public List<DoctorResource> resourceMaking(List<Doctor> list, List<DoctorResource> doctors ){
        for (int i = 0; i < list.size(); i++) {
            Doctor doctor = list.get(i);
            doctors.add(new DoctorResource(doctor.getName(), doctor.getLastname()));
        }
        return doctors;
    }

}
