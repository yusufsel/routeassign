package com.ysf.routeassign.vehicle;

import com.ysf.routeassign.route.RouteDAO;
import com.ysf.routeassign.route.RouteRepository;
import com.ysf.routeassign.route.dtos.CreateOrUpdateRouteRequestDTO;
import com.ysf.routeassign.route.dtos.GetRouteResponseDTO;
import com.ysf.routeassign.vehicle.dtos.CreateOrUpdateVehicleRequestDTO;
import com.ysf.routeassign.vehicle.dtos.GetVehicleResponseDTO;
import com.ysf.routeassign.vehicle.dtos.mappers.CreateOrUpdateVehicleRequestDTOMapper;
import com.ysf.routeassign.vehicle.dtos.mappers.GetVehicleResponseDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final RouteRepository routeRepository;
    private final CreateOrUpdateVehicleRequestDTOMapper createOrUpdateVehicleRequestDTOMapper;
    private final GetVehicleResponseDTOMapper getVehicleResponseDTOMapper;

    public GetVehicleResponseDTO createVehicle(CreateOrUpdateVehicleRequestDTO createOrUpdateVehicleRequestDTO){
        VehicleDAO vehicle = createOrUpdateVehicleRequestDTOMapper.apply(createOrUpdateVehicleRequestDTO);
        return getVehicleResponseDTOMapper.apply(vehicleRepository.save(vehicle));
    }

    public List<GetVehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream().map(getVehicleResponseDTOMapper).collect(Collectors.toList());
    }

    public GetVehicleResponseDTO getVehicle(Long id) {
        return getVehicleResponseDTOMapper.apply(vehicleRepository.findById(id).orElseThrow());
    }

    public void deleteVehicle(Long id){
        vehicleRepository.deleteById(id);
    }

    public GetVehicleResponseDTO updateVehicle(Long id, CreateOrUpdateVehicleRequestDTO createOrUpdateVehicleRequestDTO){
        VehicleDAO vehicle = vehicleRepository.findById(id).orElseThrow();

        if(createOrUpdateVehicleRequestDTO.plate() != null){
            vehicle.setPlate(createOrUpdateVehicleRequestDTO.plate());
        }
        if(createOrUpdateVehicleRequestDTO.routeId() != null){
            vehicle.setRoute(routeRepository.findById(createOrUpdateVehicleRequestDTO.routeId()).orElseThrow());
        }

        return getVehicleResponseDTOMapper.apply(vehicleRepository.save(vehicle));
    }


}
