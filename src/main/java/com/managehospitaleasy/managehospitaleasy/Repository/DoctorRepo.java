package com.managehospitaleasy.managehospitaleasy.Repository;

import com.managehospitaleasy.managehospitaleasy.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}
