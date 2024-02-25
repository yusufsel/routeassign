package com.ysf.routeassign.route;


import com.ysf.routeassign.route.dtos.CreateOrUpdateRouteRequestDTO;
import com.ysf.routeassign.route.dtos.GetRouteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/routes")
public class RouteController {

    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<GetRouteResponseDTO> createRoute(@Valid @RequestBody CreateOrUpdateRouteRequestDTO createOrUpdateRouteRequestDTO){
        return ResponseEntity.ok(routeService.createRoute(createOrUpdateRouteRequestDTO));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<GetRouteResponseDTO> findRoute(@PathVariable Long id){
        return ResponseEntity.ok(routeService.getRoute(id));
    }

    @GetMapping
    public ResponseEntity<List<GetRouteResponseDTO>> findAllRoutes(){
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity deleteRoute(@PathVariable Long id){
        routeService.deleteRoute(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<GetRouteResponseDTO> updateRoute(@PathVariable Long id, @Valid @RequestBody CreateOrUpdateRouteRequestDTO createOrUpdateRouteRequestDTO){
        return ResponseEntity.ok(routeService.updateRoute(id,createOrUpdateRouteRequestDTO));
    }


}
