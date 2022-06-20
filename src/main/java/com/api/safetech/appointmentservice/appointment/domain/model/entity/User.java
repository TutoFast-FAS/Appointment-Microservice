package com.api.safetech.appointmentservice.appointment.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private String address;
    private String phone;
    private Date birthday;
}
