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

    @RequestMapping(value = "/list/doctorNames", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorsNamesList(@RequestParam(required = false) Specialization specialization,
                                              @RequestParam(required = false) Integer minRate) {
        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getList(specialization, minRate);
        DoctorResourceAssembler doctorResourceAssembler = new DoctorResourceAssembler();
        doctorResources = doctorResourceAssembler.resourceMaking(doctorList);

        return doctorResources;
    }

    @RequestMapping(value = "/list/doctorMinRate", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorByMinRate(@RequestParam(required = true) Integer minRate){

        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getList(minRate);
        DoctorResourceAssembler doctorResourceAssembler = new DoctorResourceAssembler();
        doctorResources = doctorResourceAssembler.resourceMaking(doctorList);

        return doctorResources;
    }

    @RequestMapping(value = "/list/doctorExactRate", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorExactRate(@RequestParam(required = true) Integer rate){

        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getListWithRate(rate);
        DoctorResourceAssembler doctorResourceAssembler = new DoctorResourceAssembler();
        doctorResources = doctorResourceAssembler.resourceMaking(doctorList);

        return doctorResources;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}