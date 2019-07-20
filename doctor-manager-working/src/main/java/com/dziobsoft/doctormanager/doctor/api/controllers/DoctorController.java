package com.dziobsoft.doctormanager.doctor.api.controllers;

import com.dziobsoft.doctormanager.doctor.api.assemblers.DoctorResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.DoctorResource;
import com.dziobsoft.doctormanager.doctor.models.Doctor;
import com.dziobsoft.doctormanager.doctor.services.DoctorService;
import com.dziobsoft.doctormanager.doctor.models.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorService doctorService;
    private DoctorResourceAssembler doctorResourceAssembler;

    @RequestMapping(value = "/list/doctorNames", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorsNamesList(@RequestParam(required = false) Specialization specialization,
                                              @RequestParam(required = false) Integer minRate) {
        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getList(specialization, minRate);
        doctorResources = doctorResourceAssembler.buildResources(doctorList);

        return doctorResources;
    }

    @RequestMapping(value = "/list/doctorMinRate", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorByMinRate(@RequestParam(required = true) Integer minRate){

        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getList(minRate);
        doctorResources = doctorResourceAssembler.buildResources(doctorList);

        return doctorResources;
    }

    @RequestMapping(value = "/list/doctorExactRate", produces = "application/json", method = RequestMethod.GET)
    public List<DoctorResource> doctorExactRate(@RequestParam(required = true) Integer rate){

        List<DoctorResource> doctorResources;
        List<Doctor> doctorList = doctorService.getListWithRate(rate);
        doctorResources = doctorResourceAssembler.buildResources(doctorList);

        return doctorResources;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Autowired
    public void setDoctorResourceAssembler(DoctorResourceAssembler doctorResourceAssembler) { this.doctorResourceAssembler =doctorResourceAssembler; }
}