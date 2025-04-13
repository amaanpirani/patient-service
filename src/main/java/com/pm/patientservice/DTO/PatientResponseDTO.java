package com.pm.patientservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDTO {
    private String id;
    private String name;
    private String firstName;
    private String email;
    private String address;
    private String dateOfBirth;
    private String registeredDate;
}
