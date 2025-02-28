package com.lawal.transit.global;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.station.model.Station;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "station_blocks")
public class StationBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToOne
    @JoinColumn(name = "block_id")
    private Block block;
}