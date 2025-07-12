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
    public Bill createBill(Bill bill){
        try{
            System.out.println(
                    "Adding Bill by id"
            );
            return bill;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }

    public void deleteBill (Long id){
        try{
            System.out.println(
                    "Deleting Bill by id"
            );
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
        }
    }

    public Bill updateBill(Bill bill){
        try{
            System.out.println(
                    "Updating bill by id"
            );
            return bill;
        }catch(Exception e){
            System.out.println("Error message : " +  e.getMessage());
            return null;
        }
    }
}
