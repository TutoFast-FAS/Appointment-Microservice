package com.api.safetech.appointmentservice.appointment.domain.persistence;

import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserId(Integer userId);
    List<Appointment> findByTechnicalId(Integer technicalId);
    List<Appointment> findByUserIdAndTechnicalId(Integer userId, Integer technicalId);
}

