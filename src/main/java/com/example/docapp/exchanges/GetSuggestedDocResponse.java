package com.example.docapp.exchanges;

import com.example.docapp.dto.DoctorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetSuggestedDocResponse {
    @NotNull
    private List<DoctorDto> list;

}
