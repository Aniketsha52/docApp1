package com.example.docapp.services;

import com.example.docapp.dto.DoctorDto;
import com.example.docapp.dto.PatientDto;
import com.example.docapp.exceptions.DoctorNotFoundException;
import com.example.docapp.exceptions.MatchCityNotFoundException;
import com.example.docapp.exchanges.GetDoctorRequest;
import com.example.docapp.exchanges.GetSuggestedDocResponse;
import com.example.docapp.models.DoctorEntity;
import com.example.docapp.repositoryservices.IDoctorRepoService;
import com.example.docapp.repositoryservices.IPatientRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService{
    @Autowired
    private IDoctorRepoService doctorRepoService;
    @Autowired
    private IPatientRepoService patientRepoService;



    @Override
    public String createDoctor(GetDoctorRequest getDoctorRequest) {
        DoctorEntity doctorEntity = new DoctorEntity(getDoctorRequest.getDoctorName(),
                getDoctorRequest.getDoctorCity(), getDoctorRequest.getEmail(),getDoctorRequest.getPhoneNumber(),getDoctorRequest.getSpeciality());
        DoctorDto doctorDto = doctorRepoService.addDoctor(doctorEntity);
        return doctorDto.getId();
    }

    @Override
    public GetSuggestedDocResponse suggestDoctor(String id) throws DoctorNotFoundException, MatchCityNotFoundException{
        List<DoctorDto> doctorDtoList = doctorRepoService.getAllDoctor();
        PatientDto patientDto = patientRepoService.findPatientById(id);
        List<DoctorDto> suggestedDoc = new LinkedList<>();
        for (DoctorDto d : doctorDtoList){
            String city = d.getDoctorCity().trim();
            if (patientDto.getPatientCity().equalsIgnoreCase(city)){
                String symptom = patientDto.getSymptom().toLowerCase();
                if((symptom.equalsIgnoreCase("Arthritis") || symptom.equalsIgnoreCase("Backpain") || symptom.equalsIgnoreCase("Tissue injuries")) && d.getSpeciality().equalsIgnoreCase("Orthopedic")){
                    suggestedDoc.add(d);
                }else if(symptom.equalsIgnoreCase("Dysmenorrhea") && d.getSpeciality().equalsIgnoreCase("Gynecology")){
                    suggestedDoc.add(d);
                }else if((symptom.equalsIgnoreCase("Skin infection") || symptom.equalsIgnoreCase("skin burn")) && d.getSpeciality().equalsIgnoreCase("Dermatology"))
                {
                    suggestedDoc.add(d);
                }
                else if(symptom.equalsIgnoreCase("Ear pain") && d.getSpeciality().equalsIgnoreCase("ENT")){
                    suggestedDoc.add(d);
                }
            }
        }
        if(suggestedDoc.isEmpty()){
            throw new DoctorNotFoundException("“There isn’t any doctor present at your location for your symptom”");
        }
        GetSuggestedDocResponse getSuggestedDocResponse = new GetSuggestedDocResponse(suggestedDoc);
        return getSuggestedDocResponse;
    }

}
