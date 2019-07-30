package com.dziobsoft.doctormanager.patient;

import com.dziobsoft.doctormanager.doctor.dao.PatientDao;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import com.dziobsoft.doctormanager.doctor.services.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PatientServiceImplTest {
    private PatientServiceImpl underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new PatientServiceImpl();
        PatientDao patientDaoMock = Mockito.mock(PatientDao.class);
        underTest.setPatientDao(patientDaoMock);
        List<Patient> patients = new ArrayList<>();
        Patient patient1 = Patient.builder()
                .name("Jan")
                .lastname("Kowalski")
                .birthdate(LocalDate.of(1990, 01, 01))
                .email(("janKowalski@gmail.com"))
                .build();
        patients.add(patient1);

        Patient patient2 = Patient.builder()
                .name("Darek")
                .lastname("Nowak")
                .birthdate(LocalDate.of(1995, 12, 31))
                .email("darekNowak@gmail.com")
                .build();
        patients.add(patient2);

        Mockito.when(patientDaoMock.getList()).thenReturn(patients);
    }

    @Test
    public void shouldReturnAllDoctors() {
        //given


        //when
        List<Patient> result = underTest.getList();

        //then
        assertEquals(result.size(), 2);

    }


    @Test
    public void shouldReturnOneDoctor() {
        //given
        String name = "Jan";
        String lastname = "Kowalski";

        //when
        List<Patient> result = underTest.getList(name, lastname);

        //then
        assertEquals(result.size(), 1);

    }

    @Test
    public void shouldBeVaild(){
        //given
        Patient patient = Patient.builder()
                .name("Jan")
                .lastname("Kowalski")
                .birthdate(LocalDate.of(1999,02,03))
                .email("mail@wp.pl")
                .build();

        //when
        boolean result = underTest.isValid(patient);

        //then
        assertTrue(result);
    }

    @Test
    public void shouldNotBeValid(){
        //given
        Patient patient = Patient.builder()
                .name("Jan")
                .birthdate(LocalDate.of(1999,02,03))
                .email("mail@wp.pl")
                .build();

        //when
        boolean result = underTest.isValid(patient);

        //then
        assertFalse(result);
    }


}
