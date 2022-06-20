package com.api.safetech.appointmentservice.appointment.resource;

import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appliance;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.Status;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.Technical;
import com.api.safetech.appointmentservice.appointment.domain.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String problemDescription;
    private Date scheduledAt;
    private String address;
    private Status status;
    private Integer userId;
    private Integer technicalId;
    private Integer applianceId;
    private User user;
    private Technical technical;
    private Appliance appliance;
}
