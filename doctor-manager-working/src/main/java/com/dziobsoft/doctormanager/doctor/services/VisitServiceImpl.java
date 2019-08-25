package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.dao.VisitDao;
import com.dziobsoft.doctormanager.doctor.models.Visit;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    VisitDao visitDao;

    @Override
    public List<Visit> getList(LocalDate fromDate, LocalDate toDate){
        if(fromDate == null){
            fromDate = LocalDate.now();
        }
        if(toDate == null){
            fromDate = fromDate.plusWeeks(1);
        }
        List<Visit> visitList = visitDao.getList(fromDate, toDate);
        return visitList;
    }
}
