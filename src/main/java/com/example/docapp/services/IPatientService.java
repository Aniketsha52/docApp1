package com.example.docapp.services;

import com.example.docapp.dto.PatientDto;
import com.example.docapp.exchanges.GetPatientRequest;

public interface IPatientService {
    public String createPatient(GetPatientRequest getPatientRequest);
    public PatientDto getPatientId(String id);
}
