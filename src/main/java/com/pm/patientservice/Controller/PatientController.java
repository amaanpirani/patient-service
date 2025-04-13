package com.pm.patientservice.Controller;

import com.pm.patientservice.DTO.PatientRequestDTO;
import com.pm.patientservice.DTO.PatientResponseDTO;
import com.pm.patientservice.DTO.Validators.CreatePatientValidationGroup;
import com.pm.patientservice.Service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Tag(name = "Patient", description = "API for managing patients.")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    @Operation(summary = "Get Patients.")
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok()
                .body(patients);
    }

    @PostMapping()
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({CreatePatientValidationGroup.class})
            @RequestBody
            PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok()
                .body(patientService.createPatient(patientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable
            UUID id,
            @Validated
            @RequestBody
            PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id, patientRequestDTO);
        return ResponseEntity.ok()
                .body(patientResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(
            @PathVariable
            UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent()
                .build();
    }
}
