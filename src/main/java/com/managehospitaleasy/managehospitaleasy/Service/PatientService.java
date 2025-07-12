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

}
