package com.dziobsoft.doctormanager.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public List<DocktorResource> docktorsList(@RequestParam(required = false) Specialization specialization,
                                              @RequestParam(required = false) Integer minRate) {
        List<DocktorResource> doctors = new ArrayList<>();
        List<Doctor> list = doctorService.getList(specialization, minRate);

        for(int i = 0; i < list.size(); i++){
            Doctor doctor = list.get(i);
            doctors.add(new DocktorResource(doctor.getName(), doctor.getLastname()));
        }
        return doctors;
    }

    public class DocktorResource {
        @JsonProperty
        private String name;
        @JsonProperty
        private String lastname;

        public DocktorResource(String name, String lastname) {
            this.name = name;
            this.lastname = lastname;
        }
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}