package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.models.Bill;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public List<Bill> getAllBill(){
        try{
            System.out.println("GetAllBill in service layer");
            return null;

        }catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while retrieving all bill: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id){
        try{
            System.out.println("bill in service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while retrieving bill: {}", e.getMessage());
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
            logger.error("An error occurred while adding bill: {}", e.getMessage());
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
            logger.error("An error occurred while deleting bill: {}", e.getMessage());
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
            logger.error("An error occurred while updating bill: {}", e.getMessage());
            return null;
        }
    }
}
