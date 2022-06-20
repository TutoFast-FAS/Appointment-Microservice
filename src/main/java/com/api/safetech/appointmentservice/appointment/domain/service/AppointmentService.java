package com.api.safetech.appointmentservice.appointment.domain.service;

import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment);
    Appointment update(Long appointmentId, Appointment appointment);
    Appointment delete(Long appointmentId);
    List<Appointment> getByUserId(Integer userId);
    List<Appointment> getByTechnicalId(Integer technicalId);
    List<Appointment> getByUserIdAndTechnicalId(Integer userId, Integer technicalId);
}