package com.ysf.routeassign.route.dtos;

import java.util.List;

public record GetRouteResponseDTO(
        Long id, String name, List<Long> stationIds
) {
}
