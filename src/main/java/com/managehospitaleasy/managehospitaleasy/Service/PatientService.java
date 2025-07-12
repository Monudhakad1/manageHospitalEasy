package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter @Setter
@Service
public class PatientService {



    public List<Patient> getAllPatients(){
        try{
            System.out.println("Getting all patients in serivce layer"  );
            return null;
        } catch (Exception e) {
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try{
            System.out.println(
                    "Getting patient by id"
            );
            return null;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient){
        try{
            System.out.println(
                    "Adding patient by id"
            );
            return null;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }

    public void DeletePatient(Long id){
        try{
            System.out.println(
                    "Deleting patient by id"
            );
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
        }
    }

    public Patient updatePatient(Patient patient){
        try{
            System.out.println(
                    "Updating patient by id"
            );
            return patient;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }
}
