package com.ysf.routeassign.vehicle.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateOrUpdateVehicleRequestDTO(
        @NotBlank
        @Size(min = 5,max=255)
        String plate,
        Long routeId
) {
}
