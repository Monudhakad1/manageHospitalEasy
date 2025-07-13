package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.Service.DoctorService;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService ;



    @GetMapping
    public List<Doctor> getDoctors(){
        System.out.println("Getting doctors");
        return doctorService.getAllDoctors();
    }
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor){
        System.out.println("Adding doctor");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        System.out.println("Getting doctor by id");
        return doctorService.getDoctorById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctorById(@PathVariable Long id){
        System.out.println("Deleting doctor by id");
        doctorService.DeleteDoctor(id);
    }
}
