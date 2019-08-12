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
    public ResponseEntity<String> persistPatient(@RequestBody PatientResource patientResource) {

        if (patientService.isValid(patientResource)){
            patientService.putPatient(patientResourceAssembler.buildPatient(patientResource));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
    

    @RequestMapping(value = "/updatePatient", method = RequestMethod.PUT)
    public String updatePatient(@RequestBody PatientResource patientResource,
                                @RequestParam int id){

        Patient patientDao = patientService.getPatientById(id);
        patientDao = patientResourceAssembler.updatePatient(patientResource, patientDao);
        patientService.updatePatient(patientDao);
        return "Pacjent został poprawnie zaktualizowany";
    }


    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientResourceAssembler(PatientResourceAssembler patientResourceAssembler) { this.patientResourceAssembler = patientResourceAssembler; }

}
