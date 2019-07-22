package com.dziobsoft.doctormanager.doctor.api.controllers;

import com.dziobsoft.doctormanager.doctor.api.assemblers.PatientResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.PatientResource;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import com.dziobsoft.doctormanager.doctor.services.DoctorService;
import com.dziobsoft.doctormanager.doctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;
    private PatientResourceAssembler patientResourceAssembler;

    @RequestMapping(value = "/list/patientsNameGiven", produces = "application/json", method = RequestMethod.GET)
    public List<PatientResource> patientsNamesList(@RequestParam() String name,
                                                  @RequestParam() String lastName) {
        List<PatientResource> patientResources;
        List<Patient> patientList = patientService.getList(name, lastName);
        patientResources = patientResourceAssembler.buildResources(patientList);

        return patientResources;
    }

    @RequestMapping(value = "/list/patients", produces = "application/json", method = RequestMethod.GET)
    public List<PatientResource> patientsList() {

        List<PatientResource> patientResources;
        List<Patient> patientList = patientService.getList();
        patientResources = patientResourceAssembler.buildResources(patientList);

        return patientResources;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientResourceAssembler(PatientResourceAssembler patientResourceAssembler) { this.patientResourceAssembler = patientResourceAssembler; }
}
