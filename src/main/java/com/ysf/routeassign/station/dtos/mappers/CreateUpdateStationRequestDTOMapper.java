package com.ysf.routeassign.station.dtos.mappers;

import com.ysf.routeassign.station.StationDAO;
import com.ysf.routeassign.station.dtos.CreateUpdateStationRequestDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CreateUpdateStationRequestDTOMapper implements Function<CreateUpdateStationRequestDTO, StationDAO> {
    @Override
    public StationDAO apply(CreateUpdateStationRequestDTO createStationRequestDTO) {
        return new StationDAO(createStationRequestDTO.name());
    }
}
