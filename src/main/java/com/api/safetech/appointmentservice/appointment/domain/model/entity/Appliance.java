package com.api.safetech.appointmentservice.appointment.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Appliance {
    private Long id;
    private String name;
    private  Float cost;
}
