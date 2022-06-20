package com.api.safetech.appointmentservice.appointment.domain.model.entity;

import com.api.safetech.appointmentservice.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "appointment")
public class Appointment extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String problemDescription;

    @NotNull
    private Date scheduledAt;

    @NotNull
    @NotBlank
    private String address;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @NotNull
    private Long userId;

    @NotNull
    private Long technicalId;

    @NotNull
    private Long applianceId;

    @Transient
    private User user;

    @Transient
    private Technical technical;

    @Transient
    private Appliance appliance;

}
