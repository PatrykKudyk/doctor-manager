package com.dziobsoft.doctormanager.doctor.Services;

import com.dziobsoft.doctormanager.doctor.Models.Doctor;
import com.dziobsoft.doctormanager.doctor.DAO.DoctorDao;
import com.dziobsoft.doctormanager.doctor.Models.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDao;

    @Override
    public List<Doctor> getList(Specialization specialization, Integer minRate) {
        List<Doctor> doctorList = doctorDao.getList();
        Stream<Doctor> doctorStream = doctorList.stream();
        if (specialization != null) {
            doctorStream = doctorStream.filter(doctor -> doctor.getSpecialization().equals(specialization));
        }
        if (minRate != null) {
            doctorStream = doctorStream.filter(doctor -> doctor.getRate() >= minRate);
        }

        return doctorStream.collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getList(Integer minRate){
        List<Doctor> doctorList = doctorDao.getList();
        Stream<Doctor> doctorStream = doctorList.stream();
        if(minRate != null){
            doctorStream = doctorStream.filter(doctor -> doctor.getRate() >= minRate);
        }
        return doctorStream.collect(Collectors.toList());
    }

    @Override
    public List<Doctor> getListWithRate(Integer rate){
        List<Doctor> doctorList = doctorDao.getList();
        Stream<Doctor> doctorStream = doctorList.stream();
        if(rate != null){
            doctorStream = doctorStream.filter(doctor -> doctor.getRate() == rate);
        }
        return doctorStream.collect(Collectors.toList());
    }

    @Autowired
    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
}
