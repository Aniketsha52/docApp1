package com.example.docapp.repositoryservices;

import com.example.docapp.dto.DoctorDto;
import com.example.docapp.models.DoctorEntity;
import com.example.docapp.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorRepoServiceImpl implements IDoctorRepoService {
    @Autowired
    private  DoctorRepository doctorRepository;
    @Autowired
    private  ModelMapper modelMapper = new ModelMapper();


    @Override
    public DoctorDto addDoctor(DoctorEntity doctorEntity) {
        DoctorEntity newDoctorEnt = doctorRepository.save(doctorEntity);
        DoctorDto doctorDto = modelMapper.map(newDoctorEnt,DoctorDto.class);
        return doctorDto;
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List<DoctorDto> doctorDtoList = new LinkedList<>();
        List<DoctorEntity> doctorEntityList = doctorRepository.findAll();
        for (DoctorEntity doctorEntity : doctorEntityList){
            doctorDtoList.add(modelMapper.map(doctorEntity,DoctorDto.class));
        }
        return doctorDtoList;
    }

}
