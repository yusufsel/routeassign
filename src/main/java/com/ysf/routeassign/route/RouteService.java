package com.ysf.routeassign.route;

import com.ysf.routeassign.route.dtos.CreateOrUpdateRouteRequestDTO;
import com.ysf.routeassign.route.dtos.GetRouteResponseDTO;
import com.ysf.routeassign.route.dtos.mappers.CreateOrUpdateRouteRequestDTOMapper;
import com.ysf.routeassign.route.dtos.mappers.GetRouteResponseDTOMapper;
import com.ysf.routeassign.station.StationDAO;
import com.ysf.routeassign.station.StationRepository;
import com.ysf.routeassign.station.dtos.CreateUpdateStationRequestDTO;
import com.ysf.routeassign.station.dtos.GetStationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final CreateOrUpdateRouteRequestDTOMapper createOrUpdateRouteRequestDTOMapper;
    private final GetRouteResponseDTOMapper getRouteResponseDTOMapper;
    private final StationRepository stationRepository;

    public GetRouteResponseDTO createRoute(CreateOrUpdateRouteRequestDTO createRouteRequestDTO){
        RouteDAO route = createOrUpdateRouteRequestDTOMapper.apply(createRouteRequestDTO);
        return getRouteResponseDTOMapper.apply(routeRepository.save(route));
    }

    public List<GetRouteResponseDTO> getAllRoutes() {
        return routeRepository.findAll().stream().map(getRouteResponseDTOMapper).collect(Collectors.toList());
    }

    public GetRouteResponseDTO getRoute(Long id) {
        return getRouteResponseDTOMapper.apply(routeRepository.findById(id).orElseThrow());
    }

    public void deleteRoute(Long id){
        routeRepository.deleteById(id);
    }

    public GetRouteResponseDTO updateRoute(Long id, CreateOrUpdateRouteRequestDTO createOrUpdateRouteRequestDTO){
        RouteDAO route = routeRepository.findById(id).orElseThrow();

        if(createOrUpdateRouteRequestDTO.name() != null){
            route.setName(createOrUpdateRouteRequestDTO.name());
        }
        if(createOrUpdateRouteRequestDTO.stationIds() != null && !createOrUpdateRouteRequestDTO.stationIds().isEmpty()){
            route.setStations(createOrUpdateRouteRequestDTO.stationIds()
                    .stream()
                    .map(a->stationRepository.findById(a).orElseThrow())
                    .collect(Collectors.toSet()));
        }

        return getRouteResponseDTOMapper.apply(routeRepository.save(route));
    }

}
