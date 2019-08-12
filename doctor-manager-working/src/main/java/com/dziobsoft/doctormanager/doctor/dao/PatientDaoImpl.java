package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Patient> getList(){
        return entityManager.createQuery("Select p from Patient p", Patient.class).getResultList();
    }

    @Transactional
    @Override
    public void persist(Patient patient){
        entityManager.persist(patient);
    }

    @Override
    public Patient getPatientById(long id) {
        return entityManager.createQuery("Select p from Patient p where p.id = :patientId", Patient.class).setParameter("patientId", id).getSingleResult();
    }

    @Transactional
    @Override
    public void updateName(Patient patient, String name){
        Patient patientEntity = entityManager.find(Patient.class, patient.getId());
        patientEntity.setName(name);
    }

    @Transactional
    @Override
    public void updatePatient(Patient patient){
        Patient patientEntity = entityManager.find(Patient.class, patient.getId());
        patientEntity.setName(patient.getName());
        patientEntity.setLastname(patient.getLastname());
        patientEntity.setBirthdate(patient.getBirthdate());
        patientEntity.setEmail(patient.getEmail());
    }
}
