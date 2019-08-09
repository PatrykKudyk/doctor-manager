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

    @Override
    public Boolean isValid(PatientResource patient){
        if(patient.getName() == null){
            return false;
        }
        if(patient.getLastname() == null){
            return false;
        }
        if(patient.getBirthdate() == null){
            return false;
        }
        if(patient.getEmail() == null){
            return false;
        }
        return true;
    }

    @Override
    public void putPatient(Patient patient){
        patientDao.persist(patient);
    }

    @Override
    public Patient getPatientById(long id){
        return patientDao.getPatientById(id);
    }

    @Override
    public void updatePatientName(Patient patient, String name){
        patientDao.updateName(patient, name);
    }

    @Override
    public void updatePatient(Patient patient){
        patientDao.updatePatient(patient);
    }

    @Autowired
    public void setPatientDao(PatientDao patientDao) { this.patientDao = patientDao; }
}
