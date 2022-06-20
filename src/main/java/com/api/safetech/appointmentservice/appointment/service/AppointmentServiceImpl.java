package com.api.safetech.appointmentservice.appointment.service;

import com.api.safetech.appointmentservice.appointment.client.ApplianceClient;
import com.api.safetech.appointmentservice.appointment.client.TechnicalClient;
import com.api.safetech.appointmentservice.appointment.client.UserClient;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appliance;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appointment;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.Technical;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.User;
import com.api.safetech.appointmentservice.appointment.domain.persistence.AppointmentRepository;
import com.api.safetech.appointmentservice.appointment.domain.service.AppointmentService;
import com.api.safetech.appointmentservice.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final static String ENTITY = "Appointment";
    private final static String ENTITY2 = "User";
    private final static String ENTITY3 = "Technical";
    private final static String ENTITY4 = "Appliance";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    UserClient userClient;

    @Autowired
    TechnicalClient technicalClient;

    @Autowired
    ApplianceClient applianceClient;

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long appointmentId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
        if(null != appointment){
            User user = userClient.getUserById(appointment.getUserId()).getBody();
            appointment.setUser(user);
            Technical technical = technicalClient.getById(appointment.getTechnicalId()).getBody();
            appointment.setTechnical(technical);
            Appliance appliance = applianceClient.getApplianceById(appointment.getApplianceId()).getBody();
            appointment.setAppliance(appliance);
        }
        return appointment;
    }

    @Override
    public Appointment create(Appointment request) {
        return appointmentRepository.save(request);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment request) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> appointmentRepository.save(
                        appointment.withProblemDescription(request.getProblemDescription())
                                .withScheduledAt(request.getScheduledAt())
                                .withAddress(request.getAddress())
                                .withStatus(request.getStatus())
                                .withUserId(request.getUserId())
                                .withTechnicalId(request.getTechnicalId())
                                .withApplianceId(request.getApplianceId())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment delete(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return appointment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public List<Appointment> getByUserId(Integer userId) {
        return appointmentRepository.findByUserId(userId);
    }

    @Override
    public List<Appointment> getByTechnicalId(Integer technicalId) {
        return appointmentRepository.findByTechnicalId(technicalId);
    }

    @Override
    public List<Appointment> getByUserIdAndTechnicalId(Integer userId, Integer technicalId) {
        return appointmentRepository.findByUserIdAndTechnicalId(userId, technicalId);
    }
}