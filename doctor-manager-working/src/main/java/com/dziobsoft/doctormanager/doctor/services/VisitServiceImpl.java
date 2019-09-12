package com.dziobsoft.doctormanager.doctor.services;

import com.dziobsoft.doctormanager.doctor.api.resources.VisitResource;
import com.dziobsoft.doctormanager.doctor.dao.VisitDao;
import com.dziobsoft.doctormanager.doctor.models.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private VisitDao visitDao;

    @Override
    public List<Visit> getList(LocalDate fromDate, LocalDate toDate){
        if(fromDate == null){
            fromDate = LocalDate.now();
        }
        if(toDate == null){
            toDate = fromDate.plusWeeks(1);
        }
        List<Visit> visitList = visitDao.getList(fromDate, toDate);
        return visitList;
    }

    @Override
    public Boolean isValid(VisitResource visitResource){
        if(visitResource.getDoctor() == null){
            return false;
        }
        if(visitResource.getPatient() == null){
            return false;
        }
        if(visitResource.getDate() == null){
            return false;
        }
        if(visitResource.getDuration() == null){
            return false;
        }
        if(visitResource.getVisitType() == null){
            return false;
        }
        if(visitResource.getPrice() == null){
            return false;
        }
        return true;
    }

    @Override
    public void putVisit(Visit visit){

        visitDao.persist(visit);
    }

    @Override
    public void deleteVisit(long id){
        visitDao.deleteVisit(id);
    }

    @Autowired
    public void setVisitDao(VisitDao visitDao) { this.visitDao = visitDao; }
}
