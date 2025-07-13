package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.Service.BillService;
import com.managehospitaleasy.managehospitaleasy.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping
    public List<Bill> getBills(){
        System.out.println("Getting bills");
        return billService.getAllBill();
    }

    @PostMapping
    public Bill addBill(@RequestBody Bill bill){
        System.out.println("Adding bill");
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("Getting bill by id");
        return billService.getBillById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBillById(@PathVariable Long id){
        System.out.println("Deleting bill by id");
        billService.deleteBill(id);
    }
}
