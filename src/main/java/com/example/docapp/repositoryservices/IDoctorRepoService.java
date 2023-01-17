package com.example.docapp.repositoryservices;

import com.example.docapp.dto.DoctorDto;
import com.example.docapp.models.DoctorEntity;

import java.util.List;

public interface IDoctorRepoService {
    public DoctorDto addDoctor(DoctorEntity doctorEntity);
    public List<DoctorDto> getAllDoctor();

}
