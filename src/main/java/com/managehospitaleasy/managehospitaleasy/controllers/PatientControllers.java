package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.Service.PatientService;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import com.managehospitaleasy.managehospitaleasy.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllers {
//service Layer with controller layer

    @Autowired
    private PatientService patientService;





    @GetMapping
    public List<Patient> getAllPatients(){
        System.out.println("Getting all patients");
        return patientService.getAllPatients();

    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        System.out.println("Adding a patient");
        return patientService.createPatient(patient);
    }

@GetMapping("/{id}")
    public Patient getPatientById (@PathVariable Long id){
        System.out.println("Getting patient by id");

        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id){
        System.out.println("Deleting a patient");
         patientService.deletePatient(id);
    }
    @PostMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        System.out.println("Updating Patient by id");
        return patientService.updatePatient(patient);
    }
}
// controller -> service -> repository ->