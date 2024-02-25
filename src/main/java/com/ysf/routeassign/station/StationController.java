package com.ysf.routeassign.station;

import com.ysf.routeassign.station.dtos.CreateUpdateStationRequestDTO;
import com.ysf.routeassign.station.dtos.GetStationResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/stations")
public class StationController {

    private final StationService stationService;


    @GetMapping(path = "{id}")
    public ResponseEntity<GetStationResponseDTO> findStation(@PathVariable Long id){
        return ResponseEntity.ok(stationService.getStation(id));
    }

    @GetMapping
    public ResponseEntity<List<GetStationResponseDTO>> findAllStations(){
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @PostMapping
    public ResponseEntity<GetStationResponseDTO> createStation(@RequestBody CreateUpdateStationRequestDTO createUpdateStationRequestDTO){
        return ResponseEntity.ok(stationService.createStation(createUpdateStationRequestDTO));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<GetStationResponseDTO> updateStation(@PathVariable Long id, @RequestBody CreateUpdateStationRequestDTO createUpdateStationRequestDTO){
        return ResponseEntity.ok(stationService.updateStation(id,createUpdateStationRequestDTO));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteStation(@PathVariable Long id){
        stationService.deleteStation(id);
        return ResponseEntity.ok().build();
    }

}
