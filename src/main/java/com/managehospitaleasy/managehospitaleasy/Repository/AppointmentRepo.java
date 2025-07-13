package com.managehospitaleasy.managehospitaleasy.Repository;

import com.managehospitaleasy.managehospitaleasy.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
}
