package com.example.docapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    @NotNull
    private String Id;
    @NotNull
    private String patientName;
    @NotNull
    private String patientCity;
    @NotNull
    private String email;
    @NotNull
    private Long phoneNumber;
    @NotNull
    private String symptom;
}
