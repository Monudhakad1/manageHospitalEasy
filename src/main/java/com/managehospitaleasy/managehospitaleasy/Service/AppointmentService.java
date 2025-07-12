package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Appointment;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.springframework.boot.system.ApplicationPid;

import java.util.List;

public class AppointmentService {
    public List<Appointment> getAllAppointments(){
        try{
            System.out.println("Appointment in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try{
            System.out.println("Appointment in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }
    public Appointment createAppointment(Appointment appointment){
        try{
            System.out.println(
                    "Adding Doctor by id"
            );
            return appointment;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }

    public void DeleteAppointment (Long id ){
        try{
            System.out.println(
                    "Deleting Appointment by id"
            );
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
        }
    }

    public Appointment updateAppointment(Appointment appointment){
        try{
            System.out.println ("Updating Appointment by id");
            return appointment;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }
}
