package com.dziobsoft.doctormanager.doctor.API.Controllers;

import com.dziobsoft.doctormanager.doctor.API.Assembler.DoctorResourceAssembler;
import com.dziobsoft.doctormanager.doctor.API.Resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.Models.Doctor;
import com.dziobsoft.doctormanager.doctor.Services.DoctorService;
import com.dziobsoft.doctormanager.doctor.Models.Specialization;
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
    public List<DoctorResource> docktorsList(@RequestParam(required = false) Specialization specialization,
                                              @RequestParam(required = false) Integer minRate) {
        List<DoctorResource> doctors;
        List<Doctor> list = doctorService.getList(specialization, minRate);
        DoctorResourceAssembler doctorResourceAssembler = new DoctorResourceAssembler();
        doctors = doctorResourceAssembler.resourceMaking(list);
        return doctors;
    }



    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}