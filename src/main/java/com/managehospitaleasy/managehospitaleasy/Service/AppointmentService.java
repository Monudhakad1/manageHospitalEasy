package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.Repository.AppointmentRepo;
import com.managehospitaleasy.managehospitaleasy.models.Appointment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.aop.target.AbstractPoolingTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private static Logger logger= LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepo appointmentRepo;


    public List<Appointment> getAllAppointments(){
        try{
            System.out.println("Appointment in service layer");
            return appointmentRepo.findAll();

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while updating appointment in service: {}", e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try{
            System.out.println("Appointment in service layer");
            Optional<Appointment> appointment=appointmentRepo.findById(id);
            if(appointment.isPresent()){
                return appointment.get();
            }
            else
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while updating appointment in service: {}", e.getMessage() );
            return null;
        }
    }
    public Appointment createAppointment(Appointment appointment){
        try{
            System.out.println(
                    "Adding Doctor by id"
            );
            appointmentRepo.save(appointment);
            return appointment;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while updating appointment in service: {}", e.getMessage());
            return null;
        }
    }

    public void DeleteAppointment (Long id ){
        try{
            System.out.println(
                    "Deleting Appointment by id"
            );
            Optional<Appointment> appointment=appointmentRepo.findById(id);
            if(appointment.isPresent()){
                appointmentRepo.deleteById(id);
            }
            else {
                System.out.println("Appointment not found");
            }
        }catch(Exception e){

            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while updating appointment in service: {}", e.getMessage());
        }
    }

    public Appointment updateAppointment(Long id ,  Appointment updatedAppointment){
        try{
            System.out.println ("Updating Appointment by id");
            Optional<Appointment> existingAppointment = appointmentRepo.findById(id);
            if(existingAppointment.isPresent()){
                Appointment a=existingAppointment.get();
                a.setPatientId(updatedAppointment.getPatientId());
                a.setDoctorId(updatedAppointment.getDoctorId());
            }

            return updatedAppointment;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while updating appointment in service: {}", e.getMessage());
            return null;
        }
    }
}
