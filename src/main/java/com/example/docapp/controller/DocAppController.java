package com.example.docapp.controller;

import com.example.docapp.exceptions.DoctorNotFoundException;
import com.example.docapp.exceptions.MatchCityNotFoundException;
import com.example.docapp.exchanges.*;
import com.example.docapp.services.IDoctorService;
import com.example.docapp.services.IPatientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
public class DocAppController {
    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IPatientService patientService;
    @PostMapping("/doctor")
    public ResponseEntity<GetDoctorResponseId> addDoctor(@Valid @RequestBody GetDoctorRequest getDoctorRequest){
        GetDoctorResponseId getDoctorResponseId;
        log.info("add doctor called with {}",getDoctorRequest);
        String id = doctorService.createDoctor(getDoctorRequest);
        getDoctorResponseId = new GetDoctorResponseId(id);
        log.info("adding Doctor returned",id);
       return ResponseEntity.ok().body(getDoctorResponseId);
    }

    @PostMapping("/patient")
    public ResponseEntity<GetPatientResponseId> addPatient(@Valid @RequestBody  GetPatientRequest getPatientRequest){
        GetPatientResponseId getPatientResponseId;
       log.info("add patient called with {}",getPatientRequest);
       String id = patientService.createPatient(getPatientRequest);
       getPatientResponseId = new GetPatientResponseId(id);
       log.info("addingPatient returned",id);
       return ResponseEntity.ok().body(getPatientResponseId);
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<GetSuggestedDocResponse> suggestPatientId(@PathVariable("id")  String id){
            log.info("get suggested doctor called with {}",id);
            GetSuggestedDocResponse getSuggestedDocResponse;
            getSuggestedDocResponse = doctorService.suggestDoctor(id);
            log.info("get suggested doctor {}", getSuggestedDocResponse);
            return ResponseEntity.ok().body(getSuggestedDocResponse);

    }
    //handling exception for city do not match
    @ExceptionHandler(value = MatchCityNotFoundException.class)
    public String exceptionHandlerForCityNotFound(){
       return  "We are still waiting to expand to your location";
    }
    //handling exception for doctor not found
    @ExceptionHandler(value = DoctorNotFoundException.class)
    public String exceptionHandlerForDocNotFound(){
        return "There isn’t any doctor present at your location for your symptom";
    }


}
