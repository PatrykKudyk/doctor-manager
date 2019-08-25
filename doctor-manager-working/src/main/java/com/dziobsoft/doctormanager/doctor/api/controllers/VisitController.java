package com.dziobsoft.doctormanager.doctor.api.controllers;


import com.dziobsoft.doctormanager.doctor.api.assemblers.VisitResourceAssembler;
import com.dziobsoft.doctormanager.doctor.api.resources.VisitResource;
import com.dziobsoft.doctormanager.doctor.models.Visit;
import com.dziobsoft.doctormanager.doctor.services.VisitService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<VisitResource> visitListGet(@RequestParam(required = false) @DateTimeFormat(pattern="MMddyyyy") LocalDate fromDate,
                                            @RequestParam(required = false) @DateTimeFormat(pattern="MMddyyyy") LocalDate toDate){
        List<VisitResource> visitResourceList;
        List<Visit> visitList = visitService.getList(fromDate, toDate);
        visitResourceList = visitResourceAssembler.buildResources(visitList);
        return visitResourceList;
    }
}
