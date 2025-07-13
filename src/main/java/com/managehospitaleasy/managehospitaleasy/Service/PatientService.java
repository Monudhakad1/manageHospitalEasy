package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Patient;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    public List<Patient> getAllPatients() {
        try {
            System.out.println("Getting all patients in service layer");

            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching all patient details: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            System.out.println("Getting patient by id");

            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while fetching patient by id: {}", e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            System.out.println("Adding patient");

            return null;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while creating patient: {}", e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            System.out.println("Deleting patient by id");

        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while deleting patient: {}", e.getMessage());
        }
    }

    public Patient updatePatient(Patient patient) {
        try {
            System.out.println("Updating patient");

            return patient;
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
            logger.error("An error occurred while updating patient: {}", e.getMessage());
            return null;
        }
    }
}
