package com.dziobsoft.doctormanager.doctor;

import com.dziobsoft.doctormanager.doctor.DAO.DoctorDao;
import com.dziobsoft.doctormanager.doctor.Models.Doctor;
import com.dziobsoft.doctormanager.doctor.Models.Specialization;
import com.dziobsoft.doctormanager.doctor.Services.DoctorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DoctorServiceImplTest {
    private DoctorServiceImpl underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new DoctorServiceImpl();
        DoctorDao doctorDaoMock = Mockito.mock(DoctorDao.class);
        underTest.setDoctorDao(doctorDaoMock);
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
        Mockito.when(doctorDaoMock.getList()).thenReturn(doctors);
    }

    @Test
    public void shouldReturnAllDoctors() {
        //given
        Specialization specialization = null;
        Integer minRate = null;

        //when
        List<Doctor> result = underTest.getList(specialization, minRate);

        //then
        assertEquals(result.size(), 4);

    }

    @Test
    public void shouldReturnZeroDoctors(){
        //given
        Specialization specialization = null;
        Integer minRate = 999;

        //when
        List<Doctor> result = underTest.getList(specialization, minRate);

        //then
        assertEquals(result.size(), 0);
    }

    @Test
    public void shouldReturnWellRatedDoctors(){
        //given
        Specialization specialization = null;
        Integer minRate = 4;

        //when
        List<Doctor> result = underTest.getList(specialization, minRate);

        //then
        assertEquals(result.size(), 2);
    }

    @Test
    public void shouldReturnJustOPTYKDoctors(){
        //given
        Specialization specialization = Specialization.OPTYK;
        Integer minRate = null;

        //when
        List<Doctor> result = underTest.getList(specialization, minRate);

        //then
        assertEquals(result.size(), 2);
    }
}