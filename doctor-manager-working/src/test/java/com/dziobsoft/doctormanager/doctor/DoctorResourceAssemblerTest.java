package com.dziobsoft.doctormanager.doctor;

import com.dziobsoft.doctormanager.doctor.api.assemblers.DoctorResourceAssembler;;
import com.dziobsoft.doctormanager.doctor.models.Doctor;
import com.dziobsoft.doctormanager.doctor.models.Specialization;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoctorResourceAssemblerTest {
    private DoctorResourceAssembler underTest;

    @Before
    public void setUP() throws Exception{
        underTest = new DoctorResourceAssembler();
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

        Doctor doctor3 = Doctor.builder()
                .name("Ania")
                .lastname("Malinowska")
                .specialization(Specialization.INTERNISTA)
                .rate(2)
                .build();
        doctorList.add(doctor3);

        Doctor doctor4 = Doctor.builder()
                .name("Darek")
                .lastname("Pietrzykowski")
                .specialization(Specialization.KARDIOLOG)
                .rate(3)
                .build();
        doctorList.add(doctor2);

        Doctor doctor5 = Doctor.builder()
                .name("Stefan")
                .lastname("Kolano")
                .specialization(Specialization.CHIRURG)
                .rate(1)
                .build();
        doctorList.add(doctor3);
    }

    @Test
    public void shouldReturnAllDoctors(){
        //given

        //when
        //List<DoctorResource> result = underTest.resourceMaking();
        //then
    }
}
