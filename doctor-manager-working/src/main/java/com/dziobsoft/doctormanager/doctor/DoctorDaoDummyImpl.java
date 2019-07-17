package com.dziobsoft.doctormanager.doctor;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Primary
@Profile("integration-test")
public class DoctorDaoDummyImpl implements DoctorDao {


    @Override
    public List<Doctor> getList() {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor1 = Doctor.builder()
                .name("Jan")
                .lastname("Kowalski")
                .specialization(Specialization.OPTYK)
                .rate(4)
                .build();
        doctors.add(doctor1);

        Doctor doctor2 = Doctor.builder()
                .name("Kasia")
                .lastname("Nowak")
                .specialization(Specialization.KARDIOLOG)
                .rate(5)
                .build();
        doctors.add(doctor2);

        Doctor doctor3 = Doctor.builder()
                .name("Harry")
                .lastname("Potter")
                .specialization(Specialization.OPTYK)
                .rate(2)
                .build();
        doctors.add(doctor3);

        Doctor doctor4 = Doctor.builder()
                .name("Hermiona")
                .lastname("Granegr")
                .specialization(Specialization.CHIRURG)
                .rate(1)
                .build();
        doctors.add(doctor4);

        return doctors;
    }
}