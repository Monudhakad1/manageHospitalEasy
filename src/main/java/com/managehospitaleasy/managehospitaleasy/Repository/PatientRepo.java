package com.managehospitaleasy.managehospitaleasy.Repository;

import com.managehospitaleasy.managehospitaleasy.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}
