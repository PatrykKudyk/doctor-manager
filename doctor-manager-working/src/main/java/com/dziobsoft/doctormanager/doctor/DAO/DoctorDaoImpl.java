package com.dziobsoft.doctormanager.doctor.DAO;

import com.dziobsoft.doctormanager.doctor.Models.Doctor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Doctor> getList() {
        return entityManager.createQuery("Select d from Doctor d").getResultList();
    }
}
