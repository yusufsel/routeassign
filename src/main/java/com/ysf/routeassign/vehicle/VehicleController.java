package com.ysf.routeassign.vehicle;

import com.ysf.routeassign.vehicle.dtos.CreateOrUpdateVehicleRequestDTO;
import com.ysf.routeassign.vehicle.dtos.GetVehicleResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<GetVehicleResponseDTO> createVehicle(@Valid @RequestBody CreateOrUpdateVehicleRequestDTO createOrUpdateVehicleRequestDTO){
        return ResponseEntity.ok(vehicleService.createVehicle(createOrUpdateVehicleRequestDTO));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<GetVehicleResponseDTO> findVehicle(@PathVariable Long id){
        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @GetMapping
    public ResponseEntity<List<GetVehicleResponseDTO>> findAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<GetVehicleResponseDTO> updateVehicle(@PathVariable Long id,@Valid @RequestBody CreateOrUpdateVehicleRequestDTO createOrUpdateVehicleRequestDTO){
        return ResponseEntity.ok(vehicleService.updateVehicle(id,createOrUpdateVehicleRequestDTO));
    }

}
