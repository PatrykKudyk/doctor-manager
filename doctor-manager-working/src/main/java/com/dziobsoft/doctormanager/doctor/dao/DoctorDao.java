package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> getList();
}
