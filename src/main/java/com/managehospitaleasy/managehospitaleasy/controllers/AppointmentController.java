package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.models.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @GetMapping
    public List<Appointment> getAllAppointments(){
        System.out.println("Getting all appointments");
        return null;
    }

    @PostMapping
    public Appointment addAppoitment (@RequestBody Appointment appointment){
        System.out.println("Adding appointment");
        return null;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        System.out.println("Getting appointment by id");
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id){
        System.out.println("Deleting appointment by id");
    }



}
