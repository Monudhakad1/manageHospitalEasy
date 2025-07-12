package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Doctor;

import java.util.List;

public class DoctorService {

    public List<Doctor> getAllDoctors(){
        try{
            System.out.println("getAllDoctors in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(int id){
        try{
            System.out.println("getDoctorById in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }
}
