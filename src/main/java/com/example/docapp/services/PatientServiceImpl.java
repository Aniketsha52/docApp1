package com.example.docapp.services;

import com.example.docapp.dto.PatientDto;
import com.example.docapp.exchanges.GetPatientRequest;
import com.example.docapp.models.PatientEntity;
import com.example.docapp.repositories.PatientRepository;
import com.example.docapp.repositoryservices.IPatientRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements IPatientService{
    @Autowired
    private IPatientRepoService patientRepoService;


    @Override
    public String createPatient(GetPatientRequest getPatientRequest) {
        PatientEntity patientEntity = new PatientEntity(getPatientRequest.getPatientName(),
                getPatientRequest.getPatientCity(), getPatientRequest.getEmail(), getPatientRequest.getPhoneNumber(), getPatientRequest.getSymptom());
       PatientDto patientDto = patientRepoService.addPatient(patientEntity);
       return patientDto.getId();

    }

    @Override
    public PatientDto getPatientId(String id) {
        return patientRepoService.findPatientById(id);
    }
}
