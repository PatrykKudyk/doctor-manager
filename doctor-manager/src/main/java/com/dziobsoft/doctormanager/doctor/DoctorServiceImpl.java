package com.dziobsoft.doctormanager.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDao;

    @Override
    public List<Doctor> getList(Specialization specialization, Integer minRate) {
        List<Doctor> doctorList = doctorDao.getList();
        Stream<Doctor> doctorStream = doctorList.stream();
        if(specialization != null){
            doctorStream = doctorStream.filter(doctor -> doctor.getSpecialization().equals(specialization));
        }
        if(minRate != null){
            doctorStream = doctorStream.filter(doctor -> doctor.getRate() >= minRate);
        }

        return doctorStream.collect(Collectors.toList());
    }

    @Autowired
    void setDoctorDao(DoctorDao doctorDao){
        this.doctorDao = doctorDao;
    }
}
