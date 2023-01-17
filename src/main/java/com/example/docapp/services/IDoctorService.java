package com.example.docapp.services;

import com.example.docapp.dto.DoctorDto;
import com.example.docapp.exchanges.GetDoctorRequest;
import com.example.docapp.exchanges.GetSuggestedDocResponse;
import com.example.docapp.models.DoctorEntity;

import java.util.List;

public interface IDoctorService {
    public String createDoctor(GetDoctorRequest getDoctorRequest);
    public GetSuggestedDocResponse suggestDoctor(String id);
}
