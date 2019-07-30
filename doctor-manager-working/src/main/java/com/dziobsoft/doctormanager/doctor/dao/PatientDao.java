package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Patient;

import java.util.List;

public interface PatientDao {
    List<Patient> getList();
    void persist(Patient patient);
    Patient getPatientById(long id);
    void updateName(Patient patient, String name);
    void updatePatient(Patient patientTaken, Patient patientGiven);
}
