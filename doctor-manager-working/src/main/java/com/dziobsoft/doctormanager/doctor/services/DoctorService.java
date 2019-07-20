package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.models.Doctor;
import com.dziobsoft.doctormanager.doctor.models.Specialization;

import java.util.List;

public interface DoctorService {
    List<Doctor> getList(Specialization specialization, Integer minRate);
    List<Doctor> getList(Integer minRate);
    List<Doctor> getListWithRate(Integer rate);
}
