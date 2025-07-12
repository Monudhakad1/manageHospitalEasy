package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Bill;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;

import java.util.List;

public class BillService {
    public List<Bill> getAllBill(){
        try{
            System.out.println("GetAllBill in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Bill getBillById(int id){
        try{
            System.out.println("bill in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }
}
