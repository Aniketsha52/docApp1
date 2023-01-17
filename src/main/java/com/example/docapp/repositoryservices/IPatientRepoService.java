package com.example.docapp.repositoryservices;

import com.example.docapp.dto.PatientDto;
import com.example.docapp.models.PatientEntity;

public interface IPatientRepoService {
    public PatientDto addPatient(PatientEntity patientEntity);
    public PatientDto findPatientById(String id);
}
