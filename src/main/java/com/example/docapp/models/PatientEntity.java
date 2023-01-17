package com.example.docapp.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "patient")
public class PatientEntity {
    @Id
    private String _Id;
    @NotNull
    @NotNull
    private String patientName;
    @NotNull
    @NotNull
    private String patientCity;
    @NotNull
    @NotNull
    private String email;
    @NotNull
    @NotNull
    private String phoneNumber;
    @NotNull
    @NotNull
    private String symptom;
    public PatientEntity(String patientName, String patientCity, String email, String phoneNumber, String symptom) {
        this.patientName = patientName;
        this.patientCity = patientCity;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.symptom = symptom;
    }

}
