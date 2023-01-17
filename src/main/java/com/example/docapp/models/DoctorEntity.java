package com.example.docapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "doctor")
public class DoctorEntity {
    @Id
    private String _Id;

    @NotNull
    @NotNull
    private String doctorName;
    @NotNull
    @NotNull
    private String doctorCity;
    @NotNull
    @NotNull
    private String email;
    @NotNull
    @NotNull
    private String phoneNumber;
    @NotNull
    @NotNull
    private String speciality;
    public DoctorEntity(String doctorName, String doctorCity, String email, String phoneNumber, String speciality) {
        this.doctorName = doctorName;
        this.doctorCity = doctorCity;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.speciality = speciality;
    }

}
