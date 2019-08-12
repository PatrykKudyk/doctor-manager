package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.api.resources.PatientResource;
import com.dziobsoft.doctormanager.doctor.models.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getList();
    List<Patient> getList(String name, String lastname);
    Boolean isValid(PatientResource patient);
    void putPatient(Patient patient);
    Patient getPatientById(long id);
    void updatePatientName(Patient patient, String name);
    void updatePatient(Patient patient);
    void deletePatient(long id);
}
