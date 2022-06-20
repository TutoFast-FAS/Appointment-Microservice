package com.api.safetech.appointmentservice.appointment.client;

import com.api.safetech.appointmentservice.appointment.domain.model.entity.Appliance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ApplianceHystrixFallbackFactory implements ApplianceClient{
    @Override
    public ResponseEntity<Appliance> getApplianceById(Long applianceId) {
        Appliance appliance = Appliance.builder()
                .name("none")
                .cost((float)0.00)
                .build();
        return ResponseEntity.ok(appliance);
    }
}
