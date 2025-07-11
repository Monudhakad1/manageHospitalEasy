package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @GetMapping
    public List<Doctor> getDoctors(){
        System.out.println("Getting doctors");
        return null;
    }
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        System.out.println("Adding doctor");
        return doctor;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        System.out.println("Getting doctor by id");
        return null;
    }
    @DeleteMapping
    public void deleteDoctorById(@RequestBody Doctor doctor){
        System.out.println("Deleting doctor by id");
    }
}
