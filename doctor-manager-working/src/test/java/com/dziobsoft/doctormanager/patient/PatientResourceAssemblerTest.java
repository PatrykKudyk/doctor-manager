package com.dziobsoft.doctormanager.patient;


import com.dziobsoft.doctormanager.doctor.api.assemblers.PatientResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.PatientResource;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PatientResourceAssemblerTest {
    private PatientResourceAssembler underTest;

    @Before
    public void setUP() throws Exception{
        underTest = new PatientResourceAssembler();
    }

    @Test
    public void testOfListLengthAndIfDatasAreCorrect(){
        //given
        List<Patient> patientList = new ArrayList<>();

        Patient patient1 = Patient.builder()
                .name("Jan")
                .lastname("Kowalski")
                .birthdate(LocalDate.of(1990, 01, 01))
                .email(("janKowalski@gmail.com"))
                .build();
        patientList.add(patient1);

        Patient patient2 = Patient.builder()
                .name("Darek")
                .lastname("Nowak")
                .birthdate(LocalDate.of(1995, 12, 31))
                .email("darekNowak@gmail.com")
                .build();
        patientList.add(patient2);

        //when
        List<PatientResource>  result = underTest.buildResources(patientList);

        //then
        assertEquals(result.size(), patientList.size());
        assertEquals(patientList.get(0).getName(), result.get(0).getName());
        assertEquals(patientList.get(1).getLastname(), result.get(1).getLastname());
        assertEquals(patientList.get(1).getBirthdate(), result.get(1).getBirthdate());
        assertEquals(patientList.get(0).getEmail(), result.get(0).getEmail());
    }

}

