package com.ysf.routeassign.route.dtos.mappers;


import com.ysf.routeassign.route.RouteDAO;
import com.ysf.routeassign.route.dtos.GetRouteResponseDTO;
import com.ysf.routeassign.station.StationDAO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GetRouteResponseDTOMapper implements Function<RouteDAO, GetRouteResponseDTO> {
    @Override
    public GetRouteResponseDTO apply(RouteDAO routeDAO) {
        return new GetRouteResponseDTO(
                routeDAO.getId(),
                routeDAO.getName(),
                routeDAO.getStations().stream().map(StationDAO::getId).toList()
        );
    }
}
