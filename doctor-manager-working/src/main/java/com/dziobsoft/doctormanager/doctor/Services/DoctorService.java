package com.dziobsoft.doctormanager.doctor.Services;

import com.dziobsoft.doctormanager.doctor.Models.Doctor;
import com.dziobsoft.doctormanager.doctor.Models.Specialization;

import java.util.List;

public interface DoctorService {
    List<Doctor> getList(Specialization specialization, Integer minRate);
}
