package com.dziobsoft.doctormanager.doctor.api.controllers;


import com.dziobsoft.doctormanager.doctor.api.assemblers.VisitResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.VisitResource;
import com.dziobsoft.doctormanager.doctor.models.Visit;
import com.dziobsoft.doctormanager.doctor.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    private VisitService visitService;
    private VisitResourceAssembler visitResourceAssembler;

//    @RequestMapping(value = "/{someID}", produces = "application/json", RequestMethod.GET)
//    public VisitResource visitGet(@PathVariable(value = "someID") int id){
//
//        VisitResource visitResource;
//        visitService;
//        return visitResource;
//    }

    @RequestMapping(value = "/list", produces = "application/json", method = RequestMethod.GET)
    public List<VisitResource> visitListGet(@RequestParam(required = false) @DateTimeFormat(pattern="ddMMyyyy") LocalDate fromDate,
                                            @RequestParam(required = false) @DateTimeFormat(pattern="ddMMyyyy") LocalDate toDate){
        List<VisitResource> visitResourceList = new ArrayList<>();
        List<Visit> visitList = visitService.getList(fromDate, toDate);
        visitResourceList = visitResourceAssembler.buildResources(visitList);
        return visitResourceList;
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public ResponseEntity<String> persistVisit(@RequestBody VisitResource visitResource){

        if(visitService.isValid(visitResource)){
            visitService.putVisit(visitResourceAssembler.buildVisit(visitResource));
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @RequestMapping(value = "/{someID}", method = RequestMethod.DELETE)
    public String deleteVisit(@PathVariable(value="someID") String id){

        visitService.deleteVisit(Integer.parseInt(id));
        return "Pomyślnie usunięto vizytę";
    }

    @Autowired
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Autowired
    public void setVisitResourceAssembler(VisitResourceAssembler visitResourceAssembler) { this.visitResourceAssembler = visitResourceAssembler; }

}
