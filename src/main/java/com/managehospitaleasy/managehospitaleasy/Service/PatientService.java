package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.Repository.PatientRepo;
import com.managehospitaleasy.managehospitaleasy.models.Patient;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    //Interacting with Db
    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getAllPatients() {
        try {
            System.out.println("Getting all patients in service layer");
            return patientRepo.findAll();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all patient details: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            System.out.println("Getting patient by id");

             Optional<Patient> patient =patientRepo.findById(id);
             return patient.get();
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching patient by id: {}", e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            System.out.println("Adding patient");
            patientRepo.save(patient);
            return patient;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating patient: {}", e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            System.out.println("Deleting patient by id");
            patientRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting patient: {}", e.getMessage());
        }
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        try {
            Optional<Patient> existingPatient = patientRepo.findById(id);
            if(existingPatient.isPresent()){
                Patient pat = existingPatient.get();
                pat.setName(updatedPatient.getName());
                pat.setAge(updatedPatient.getAge());
                pat.setGender(updatedPatient.getGender());
                patientRepo.save(pat);
                return pat;
            }
            else {
                logger.info("Patient not found with id {}", id);
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating patient: {}", e.getMessage());
            return null;
        }
    }
}
