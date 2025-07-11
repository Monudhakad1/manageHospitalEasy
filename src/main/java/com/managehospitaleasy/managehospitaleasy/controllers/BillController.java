package com.managehospitaleasy.managehospitaleasy.controllers;

import com.managehospitaleasy.managehospitaleasy.models.Bill;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @GetMapping
    public List<Bill> getBills(){
        System.out.println("Getting bills");
        return null;
    }

    @PostMapping
    public Bill addBill(@RequestBody Bill bill){
        System.out.println("Adding bill");
        return bill;
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        System.out.println("Getting bill by id");
        return null;
    }

    @DeleteMapping
    public void deleteBillById(@RequestBody Bill bill){
        System.out.println("Deleting bill by id");
    }
}
