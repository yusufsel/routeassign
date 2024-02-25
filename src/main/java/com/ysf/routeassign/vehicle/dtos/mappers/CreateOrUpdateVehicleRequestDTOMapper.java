package com.ysf.routeassign.vehicle.dtos.mappers;


import com.ysf.routeassign.route.RouteRepository;
import com.ysf.routeassign.vehicle.VehicleDAO;
import com.ysf.routeassign.vehicle.dtos.CreateOrUpdateVehicleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class CreateOrUpdateVehicleRequestDTOMapper implements Function<CreateOrUpdateVehicleRequestDTO, VehicleDAO> {
    private final RouteRepository routeRepository;


    @Override
    public VehicleDAO apply(CreateOrUpdateVehicleRequestDTO createOrUpdateVehicleRequestDTO) {

        VehicleDAO vehicle = new VehicleDAO();

        vehicle.setRoute(
                createOrUpdateVehicleRequestDTO.routeId() != null
                        ? routeRepository.findById(createOrUpdateVehicleRequestDTO.routeId()).orElseThrow()
                        :null
        );

        vehicle.setPlate(createOrUpdateVehicleRequestDTO.plate());

        return vehicle;
    }
}
