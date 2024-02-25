package com.ysf.routeassign.vehicle;

import com.ysf.routeassign.route.RouteDAO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "vehicles")
public class VehicleDAO {
    @Id
    @SequenceGenerator(
            name = "vehicle_sequence",
            sequenceName = "vehicle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vehicle_sequence"
    )
    Long id;
    @Column(name = "plate")
    String plate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="route_id")
    RouteDAO route;
}
