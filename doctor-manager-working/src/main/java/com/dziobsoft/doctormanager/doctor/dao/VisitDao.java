package com.dziobsoft.doctormanager.doctor.dao;

import com.dziobsoft.doctormanager.doctor.models.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitDao {
    List<Visit> getList(LocalDate fromDate, LocalDate toDate);
    void persist(Visit visit);
}
