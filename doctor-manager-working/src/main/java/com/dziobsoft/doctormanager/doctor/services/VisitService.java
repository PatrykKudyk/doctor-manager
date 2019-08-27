package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.models.Visit;

import java.time.LocalDate;
import java.util.List;

public interface VisitService {
    List<Visit> getList(LocalDate fromDate, LocalDate toDate);
}