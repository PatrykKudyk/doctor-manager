package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Visit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Repository
public class VisitDaoImpl implements VisitDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Visit> getList(LocalDate fromDate, LocalDate toDate){
        return entityManager.createQuery("Select v from Visit v where v.date " +
                "between (:fromDate) and (:toDate)", Visit.class)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
    }
}
