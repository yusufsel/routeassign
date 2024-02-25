package com.ysf.routeassign.route.dtos;


import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateOrUpdateRouteRequestDTO(
        String name,
        @Size(min = 2,max = 255)
        List<Long> stationIds
) {
}
