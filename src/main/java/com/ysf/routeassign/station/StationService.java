package com.ysf.routeassign.station;

import com.ysf.routeassign.station.dtos.CreateUpdateStationRequestDTO;
import com.ysf.routeassign.station.dtos.GetStationResponseDTO;
import com.ysf.routeassign.station.dtos.mappers.CreateUpdateStationRequestDTOMapper;
import com.ysf.routeassign.station.dtos.mappers.GetStationResponseDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StationService {
    private final StationRepository stationRepository;
    private final GetStationResponseDTOMapper getStationResponseDTOMapper;
    private final CreateUpdateStationRequestDTOMapper createUpdateStationRequestDTOMapper;

    public List<GetStationResponseDTO> getAllStations() {
        return stationRepository.findAll().stream().map(getStationResponseDTOMapper).collect(Collectors.toList());
    }

    public GetStationResponseDTO getStation(Long id) {
        return getStationResponseDTOMapper.apply(stationRepository.findById(id).orElseThrow());
    }


    public GetStationResponseDTO createStation(CreateUpdateStationRequestDTO createUpdateStationRequestDTO){

        StationDAO stationDAO = createUpdateStationRequestDTOMapper.apply(createUpdateStationRequestDTO);

        return getStationResponseDTOMapper.apply(stationRepository.save(stationDAO));
    }

    public GetStationResponseDTO updateStation(Long id, CreateUpdateStationRequestDTO createUpdateStationRequestDTO){
        StationDAO station = stationRepository.findById(id).orElseThrow();

        if(createUpdateStationRequestDTO.name() != null){
            station.setName(createUpdateStationRequestDTO.name());
        }

        return getStationResponseDTOMapper.apply(stationRepository.save(station));
    }

    public void deleteStation(Long id){
        stationRepository.deleteById(id);
    }
}
