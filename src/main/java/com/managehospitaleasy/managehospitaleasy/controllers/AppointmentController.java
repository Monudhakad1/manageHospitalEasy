package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.Service.AppointmentService;
import com.managehospitaleasy.managehospitaleasy.models.Appointment;
import com.managehospitaleasy.managehospitaleasy.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments(){
        System.out.println("Getting all appointments");
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment addAppointment (@RequestBody Appointment appointment){
        System.out.println("Adding appointment");
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        System.out.println("Getting appointment by id");
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id){
        System.out.println("Deleting appointment by id");
        appointmentService.DeleteAppointment(id);
    }

    @PostMapping("/{id}")
    public Appointment updateAppointmentById(@PathVariable Long id, @RequestBody Appointment appointment){
        System.out.println("Updating Appointment by id");
        return appointmentService.updateAppointment(appointment);
    }
}




