package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.dao.PatientDao;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;

    @Override
    public List<Patient> getList(){
        List<Patient> patientList = patientDao.getList();
        return patientList;
    }

    @Override
    public List<Patient> getList(String name, String lastname){
        List<Patient> patientList = patientDao.getList();
        Stream<Patient> patientStream = patientList.stream();
        if(name != null){
            patientStream = patientStream.filter(patient -> patient.getName().equals(name));
        }
        if(lastname != null){
            patientStream = patientStream.filter(patient -> patient.getLastname().equals(lastname));
        }
        return patientStream.collect(Collectors.toList());
    }

    @Autowired
    public void setPatientDao(PatientDao patientDao) { this.patientDao = patientDao; }
}
