package com.dziobsoft.doctormanager.doctor.API.Assembler;

import com.dziobsoft.doctormanager.doctor.API.Resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.Models.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorResourceAssembler {
    public List<DoctorResource> resourceMaking(List<Doctor> list){
        List<DoctorResource> doctors = new ArrayList<>();
        for (Doctor doctor : list) {
            doctors.add(new DoctorResource(doctor.getName(), doctor.getLastname(), doctor.getSpecialization(), doctor.getRate()));
        }
        return doctors;
    }

}