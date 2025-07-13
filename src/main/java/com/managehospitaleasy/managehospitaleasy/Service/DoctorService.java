package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.Repository.DoctorRepo;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepo doctorRepo;



    public List<Doctor> getAllDoctors() {
        try {
            System.out.println("getAllDoctors in sl");
            return doctorRepo.findAll();

        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while getting all doctors", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            System.out.println("getDoctorById in service layer");
            Optional<Doctor> doctor = doctorRepo.findById(id);
            return doctor.get();
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while getting doctor by id", e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
            System.out.println("Adding Doctor by id");
            doctorRepo.save(doctor);
            return doctor;
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while creating doctor", e.getMessage());
            return null;
        }
    }

    public void DeleteDoctor(Long id) {
        try {
            System.out.println(
                    "Deleting Doctor by id");
            Optional<Doctor> doctor = doctorRepo.findById(id);
            if(doctor.isPresent()) {
            doctorRepo.deleteById(id);}
            else {
                System.out.println("Doctor not found by id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while deleting doctor", e.getMessage());
        }
    }

    public Doctor updateDoctor(Long id, Doctor updateddoctor) {
        try {
            Optional<Doctor> existingdoctor = doctorRepo.findById(id);
            if (existingdoctor.isPresent()) {
                Doctor d = existingdoctor.get();
                d.setName(updateddoctor.getName());
                d.setSpecialty(updateddoctor.getSpecialty());
                doctorRepo.save(d);
                return d;
            }

        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while updating doctor", e.getMessage());
            return null;
        }
        return updateddoctor;
    }
}
