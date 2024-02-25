package com.ysf.routeassign.route.dtos.mappers;


import com.ysf.routeassign.route.RouteDAO;
import com.ysf.routeassign.route.dtos.CreateOrUpdateRouteRequestDTO;
import com.ysf.routeassign.station.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CreateOrUpdateRouteRequestDTOMapper implements Function<CreateOrUpdateRouteRequestDTO, RouteDAO> {
    private final StationRepository stationRepository;


    @Override
    public RouteDAO apply(CreateOrUpdateRouteRequestDTO createOrUpdateRouteRequestDTO) {

        RouteDAO route = new RouteDAO();

        route.setStations(
                createOrUpdateRouteRequestDTO.stationIds()
                        .stream()
                        .map(id->stationRepository.findById(id).orElseThrow())
                        .collect(Collectors.toSet())
        );

        route.setName(createOrUpdateRouteRequestDTO.name());

        return route;
    }
}
