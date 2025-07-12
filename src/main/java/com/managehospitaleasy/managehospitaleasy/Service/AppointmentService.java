package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Appointment;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;

import java.util.List;

public class AppointmentService {
    public List<Appointment> getAllAppointments(){
        try{
            System.out.println("AppointMent in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(int id){
        try{
            System.out.println("Appointment in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

}
