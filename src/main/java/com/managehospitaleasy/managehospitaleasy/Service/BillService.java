package com.managehospitaleasy.managehospitaleasy.Service;

import com.managehospitaleasy.managehospitaleasy.Repository.BillRepo;
import com.managehospitaleasy.managehospitaleasy.Repository.DoctorRepo;
import com.managehospitaleasy.managehospitaleasy.models.Bill;
import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private static final Logger logger = LoggerFactory.getLogger(BillService.class);
    @Autowired
    BillRepo billRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public List<Bill> getAllBill() {
        try {
            System.out.println("GetAllBill in service layer");

            return billRepo.findAll();

        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while retrieving all bill: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            System.out.println("bill in service layer");
            Optional<Bill> bill = billRepo.findById(id);
            if (bill.isPresent()) {
                return bill.get();

            }
            else return null;
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            logger.error("An error occurred while retrieving bill: {}", e.getMessage());
            return null;
        }
    }

    public Bill createBill(Bill bill) {
        try {
            System.out.println(
                    "Adding Bill by id"
            );
            billRepo.save(bill);
            return bill;
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while adding bill: {}", e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            System.out.println(
                    "Deleting Bill by id"
            );
            Optional<Bill> bill = billRepo.findById(id);
            if (bill.isPresent()) {
                billRepo.deleteById(id);
            }
            else {
                System.out.println("Bill not found by id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while deleting bill: {}", e.getMessage());
        }
    }

    public Bill updateBill(Long id,Bill updatedBill) {
        try {
            System.out.println(
                    "Updating bill by id"
            );
            Optional<Bill> existingBill = billRepo.findById(id);
            if (existingBill.isPresent()) {
                Bill b = existingBill.get();
                b.setAmount(updatedBill.getAmount());
                b.setPatientId(updatedBill.getPatientId());
                b.setAmount(updatedBill.getAmount());
                b.setStatus(updatedBill.getStatus());
                billRepo.save(b);
                return b;
            }
            return updatedBill;
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
            logger.error("An error occurred while updating bill: {}", e.getMessage());
            return null;
        }
    }
}
