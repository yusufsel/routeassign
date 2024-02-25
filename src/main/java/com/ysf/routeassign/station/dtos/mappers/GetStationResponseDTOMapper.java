package com.ysf.routeassign.station.dtos.mappers;

import com.ysf.routeassign.station.StationDAO;
import com.ysf.routeassign.station.dtos.GetStationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GetStationResponseDTOMapper implements Function<StationDAO, GetStationResponseDTO> {
    @Override
    public GetStationResponseDTO apply(StationDAO stationDAO) {
        return new GetStationResponseDTO(
                stationDAO.getId(),
                stationDAO.getName()
        );
    }
}
