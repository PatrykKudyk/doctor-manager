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
        return entityManager.createQuery("Select p from Patient p").getResultList();
    }

    @Transactional
    @Override
    public void persist(Patient patient){
        entityManager.persist(patient);
    }

}
