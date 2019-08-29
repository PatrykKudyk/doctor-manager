package com.dziobsoft.doctormanager.doctor.api.assemblers;

import com.dziobsoft.doctormanager.doctor.api.resources.VisitResource;
import com.dziobsoft.doctormanager.doctor.models.Visit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VisitResourceAssembler {


    public List<VisitResource> buildResources(List<Visit> list){

        List<VisitResource> visitResourceList = list.stream().map(visit -> {
            VisitResource visitResource = VisitResource.builder()
                    .doctorID(visit.getDoctorID())
                    .patientID(visit.getPatientID())
                    .date(visit.getDate())
                    .duration(visit.getDuration())
                    .visitType(visit.getVisitType())
                    .price(visit.getPrice())
                    .build();
            return visitResource;
        }).collect(Collectors.toList());

        return visitResourceList;
    }
}
