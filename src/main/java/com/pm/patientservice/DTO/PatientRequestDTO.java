package com.pm.patientservice.DTO;

import com.pm.patientservice.DTO.Validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "Cannot be blank.")
    @Size(max = 100, message = "Cannot exceed 100 character.")
    private String name;

    @NotBlank(message = "Cannot be blank.")
    @Email(message = "Valid Email Required.")
    private String email;

    @NotBlank(message = "Address is required.")
    private String address;

    @NotBlank(message = "Date of birth is required.")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Registration date is required.")
    private String registeredDate;
}
