package com.dziobsoft.doctormanager.Service;

import com.dziobsoft.doctormanager.Models.Doctor;
import com.dziobsoft.doctormanager.Models.Specialization;

import java.util.List;

public interface DoctorService {
    List<Doctor> getList(Specialization specialization, Integer minRate);
}
