package com.lawal.transit.lane.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.global.*;
import com.lawal.transit.lane.model.exception.NullTrafficDirectionException;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.street.model.Street;
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
    Direction DtrafficDirection;

    @ManyToOne
    @JoinColumn(name = "left_road_id", nullable = true)
    private Road leftRoadSide;

    @ManyToOne
    @JoinColumn(name = "right_road_id", nullable = true)
    private Road rightRoadSide;
}