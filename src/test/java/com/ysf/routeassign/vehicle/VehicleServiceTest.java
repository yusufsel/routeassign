package com.ysf.routeassign.vehicle;

import com.ysf.routeassign.route.RouteRepository;
import com.ysf.routeassign.vehicle.dtos.mappers.CreateOrUpdateVehicleRequestDTOMapper;
import com.ysf.routeassign.vehicle.dtos.mappers.GetVehicleResponseDTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private RouteRepository routeRepository;
    private VehicleService testingService;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setup(){
        testingService = new VehicleService(
                vehicleRepository,
                routeRepository,
                new CreateOrUpdateVehicleRequestDTOMapper(routeRepository),
                new GetVehicleResponseDTOMapper());
    }

    @Test
    void getAllVehicles() {
        //when
        testingService.getAllVehicles();

        //then
        Mockito.verify(vehicleRepository).findAll();
    }
}