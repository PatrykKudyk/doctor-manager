package com.dziobsoft.doctormanager.doctor;

import com.dziobsoft.doctormanager.doctor.api.assemblers.DoctorResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.models.Doctor;
import com.dziobsoft.doctormanager.doctor.models.Specialization;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DoctorResourceAssemblerTest {
    private DoctorResourceAssembler underTest;

    @Before
    public void setUP() throws Exception{
        underTest = new DoctorResourceAssembler();
    }

    @Test
    public void testOfListLengthAndIfDatasAreCorrect(){
        //given
        List<Doctor> doctorList = new ArrayList<>();

        Doctor doctor1 = Doctor.builder()
                .name("Jan")
                .lastname("Kowalski")
                .specialization(Specialization.OPTYK)
                .rate(4)
                .build();
        doctorList.add(doctor1);

        Doctor doctor2 = Doctor.builder()
                .name("Basia")
                .lastname("Nowak")
                .specialization(Specialization.KARDIOLOG)
                .rate(5)
                .build();
        doctorList.add(doctor2);

        //when
        List<DoctorResource>  result = underTest.buildResources(doctorList);

        //then
        assertEquals(result.size(), doctorList.size());
        assertEquals(doctorList.get(0).getName(), result.get(0).getName());
        assertEquals(doctorList.get(0).getLastname(), result.get(0).getLastname());
        assertEquals(doctorList.get(0).getSpecialization(), result.get(0).getSpecialization());
        assertEquals(doctorList.get(0).getRate(), result.get(0).getRate());
    }

}

