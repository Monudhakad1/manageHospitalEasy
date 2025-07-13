package com.managehospitaleasy.managehospitaleasy.Repository;

import com.managehospitaleasy.managehospitaleasy.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long>
{
}
