package com.example.docapp.repositoryservices;

import com.example.docapp.dto.PatientDto;
import com.example.docapp.models.PatientEntity;
import com.example.docapp.repositories.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientRepoServiceImpl implements IPatientRepoService{
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public PatientDto addPatient(PatientEntity patientEntity) {
        PatientEntity newPatientEnt = patientRepository.save(patientEntity);
        PatientDto patientDto = modelMapper.map(newPatientEnt,PatientDto.class);
        return patientDto;
    }

    @Override
    public PatientDto findPatientById(String id) {
        Optional<PatientEntity> patientEntityOpt = patientRepository.findById(id);
        if(!patientEntityOpt.isPresent()) return null;
        PatientEntity patientEntity = patientEntityOpt.get();
        PatientDto patientDto = modelMapper.map(patientEntity,PatientDto.class);
        return patientDto;
    }
}
