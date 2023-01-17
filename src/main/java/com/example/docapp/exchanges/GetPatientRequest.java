package com.example.docapp.exchanges;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPatientRequest {
    @Min(value = 3, message = "Name should be greater than 3")
    @NotNull
    private String patientName;
    @Length(max = 20, message = "city should is less than 20")
    @NotNull
    private String patientCity;
    @NotNull
    @Email
    private String email;
    @Length(max = 10,min = 10,message = "Phone number should be 10")
    @NotNull
    private String phoneNumber;
    @NotNull
    private String symptom;
}
