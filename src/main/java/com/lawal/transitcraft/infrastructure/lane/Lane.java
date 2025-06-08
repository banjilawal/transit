package com.lawal.transitcraft.infrastructure.lane;

import com.lawal.transitcraft.common.*;
import com.lawal.transitcraft.infrastructure.lane.exception.NullTrafficDirectionException;
import com.lawal.transitcraft.infrastructure.road.Road;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lanes")
public class Lane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    @NotBlank(message = NullTrafficDirectionException.MESSSAGE)
    Direction trafficDirection;

    @ManyToOne
    @JoinColumn(name = "left_road_id", nullable = true)
    private Road leftRoadSide;

    @ManyToOne
    @JoinColumn(name = "right_road_id", nullable = true)
    private Road rightRoadSide;
}