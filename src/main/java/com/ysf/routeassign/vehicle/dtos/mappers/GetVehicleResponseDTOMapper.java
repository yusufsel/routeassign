package com.ysf.routeassign.vehicle.dtos.mappers;


import com.ysf.routeassign.vehicle.VehicleDAO;
import com.ysf.routeassign.vehicle.dtos.GetVehicleResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GetVehicleResponseDTOMapper implements Function<VehicleDAO, GetVehicleResponseDTO> {
    @Override
    public GetVehicleResponseDTO apply(VehicleDAO vehicleDAO) {
        return new GetVehicleResponseDTO(
                vehicleDAO.getId(),
                vehicleDAO.getPlate(),
                vehicleDAO.getRoute()!=null?vehicleDAO.getRoute().getId():null
        );
    }
}
