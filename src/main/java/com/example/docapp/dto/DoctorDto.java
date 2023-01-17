package com.example.docapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    @NotNull
    private String Id;
    @NotNull
    private String doctorName;
    @NotNull
    private String doctorCity;
    @NotNull
    private String email;
    @NotNull
    private Long phoneNumber;
    @NotNull
    private String speciality;
}
