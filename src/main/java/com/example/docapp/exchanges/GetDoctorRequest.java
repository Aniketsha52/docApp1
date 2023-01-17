package com.example.docapp.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class GetDoctorRequest {

    @NotNull(message = "Name cannot be empty")
    @Length(min = 3,message = "name should be greater than 3")
    private String doctorName;

    @Length(max = 20, message = "city should is less than 20")
    @NotNull(message = "city can not be empty")
    private String doctorCity;
    @NotNull(message = "email cannot be empty")
    @Email
    private String email;
    @NotNull(message = "Phone Number cannot be null")
    @Length(min = 10,max = 10,message = "Phone number should be 10")
    private String phoneNumber;
    @NotNull
    private String speciality;
}
