package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import com.managehospitaleasy.managehospitaleasy.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);
    public List<Doctor> getAllDoctors(){
        try{
            System.out.println("getAllDoctors in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while getting all doctors", e.getMessage() );
            return null;
        }
    }

    public Doctor getDoctorById(Long id){
        try{
            System.out.println("getDoctorById in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while getting doctor by id", e.getMessage() );
            return null;
        }
    }
    public Doctor createDoctor(Doctor doctor){
        try{
            System.out.println(
                    "Adding Doctor by id"
            );
            return doctor;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while creating doctor", e.getMessage() );
            return null;
        }
    }

    public void DeleteDoctor(Long id){
        try{
            System.out.println(
                    "Deleting Doctor by id"
            );
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while deleting doctor", e.getMessage() );
        }
    }

    public Doctor updateDoctor(Doctor doctor){
        try{
            System.out.println(
                    "Updating Doctor by id"
            );
            return doctor;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            logger.error("An error occurred while updating doctor", e.getMessage() );
            return null;
        }
    }
}
