package com.api.safetech.appointmentservice.appointment.api;

import com.api.safetech.appointmentservice.appointment.domain.service.AppointmentService;
import com.api.safetech.appointmentservice.appointment.mapping.AppointmentMapper;
import com.api.safetech.appointmentservice.appointment.resource.AppointmentResource;
import com.api.safetech.appointmentservice.appointment.resource.CreateAppointmentResource;
import com.api.safetech.appointmentservice.appointment.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointment")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentMapper appointmentMapper;

    @Operation(summary = "Get All Appointments", description = "Get All Appointments")
    @GetMapping("appointments")
    public List<AppointmentResource> getAll(){
        return appointmentMapper.toResource(appointmentService.getAll());
    }

    @Operation(summary = "Get Appointment by Id", description = "Get Appointment by Id")
    @GetMapping("appointments/{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable Long appointmentId){
        return appointmentMapper.toResource(appointmentService.getById(appointmentId));
    }

    @Operation(summary = "Get Appointments by UserId", description = "Get All Appointments by UserId")
    @GetMapping("users/{userId}/appointments")
    public List<AppointmentResource> getAppointmentsByUserId(@PathVariable Integer userId){
        return appointmentMapper.toResource(appointmentService.getByUserId(userId));
    }

    @Operation(summary = "Get Appointments by TechnicalId", description = "Get All Appointments by TechnicalId")
    @GetMapping("technicals/{technicalId}/appointments")
    public List<AppointmentResource> getAppointmentsByTechnicalId(@PathVariable Integer technicalId){
        return appointmentMapper.toResource(appointmentService.getByTechnicalId(technicalId));
    }

    @Operation(summary = "Get Appointments by UserId and TechnicalId", description = "Get All Appointments by UserId and TechnicalId")
    @GetMapping("users/{userId}/technical/{technicalId}/appointments")
    public List<AppointmentResource> getAppointmentsByUserIdAndTechnicalId(@PathVariable Integer userId, @PathVariable Integer technicalId){
        return appointmentMapper.toResource(appointmentService.getByUserIdAndTechnicalId(userId, technicalId));
    }

    @Operation(summary = "Create New Appointment", description = "Create New Appointment")
    @PostMapping("appointments")
    public AppointmentResource createAppointment(@RequestBody CreateAppointmentResource model){
        return appointmentMapper.toResource(appointmentService.create(appointmentMapper.toModel(model)));
    }

    @Operation(summary = "Update Appointment", description = "Update Appointment")
    @PutMapping("appointments/{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource model){
        return appointmentMapper.toResource(appointmentService.update(appointmentId, appointmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Appointment", description = "Delete Appointment")
    @DeleteMapping("{appointmentId}")
    public void deleteAppointment(@PathVariable Long appointmentId){
        appointmentService.delete(appointmentId);
    }

}