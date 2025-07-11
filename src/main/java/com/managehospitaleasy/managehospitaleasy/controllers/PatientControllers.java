package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientControllers {

    @GetMapping
    public List<Patient> getAllPatients(){
        System.out.println("Getting all patients");
        return null;

    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        System.out.println("Adding a patient");
        return patient;
    }

@GetMapping("/{id}")
    public Patient getPatientById (@PathVariable Long id){
        System.out.println("Getting patient by id");

        return null;
    }

    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable Long id){
        System.out.println("Deleting a patient");
        return null;
    }
}
// controller -> service -> repository ->