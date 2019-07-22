package com.dziobsoft.doctormanager.doctor.api.controllers;

import com.dziobsoft.doctormanager.doctor.api.assemblers.PatientResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.PatientResource;
import com.dziobsoft.doctormanager.doctor.models.Patient;
import com.dziobsoft.doctormanager.doctor.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/persistPatient", method = RequestMethod.POST)
    public ResponseEntity<String> persistPatient(@RequestBody Patient patient) {
        if (patientService.isValid(patient)) {
            patientService.putPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientResourceAssembler(PatientResourceAssembler patientResourceAssembler) { this.patientResourceAssembler = patientResourceAssembler; }

}
