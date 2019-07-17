package com.dziobsoft.doctormanager.doctor.DAO;

import com.dziobsoft.doctormanager.doctor.Models.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> getList();
}
