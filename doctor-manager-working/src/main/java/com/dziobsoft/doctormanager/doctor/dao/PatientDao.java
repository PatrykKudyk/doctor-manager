package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getList();
}
