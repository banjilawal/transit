package com.lawal.transit.graph;

import com.lawal.transit.graph.contract.Vertex;
import com.lawal.transit.station.Station;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Edge {
    private int id;
    private Vertex head;
    private Vertex tail;
    private Weight weigh;

    public Edge (int id, Station head, Station tail) {
        this.id = id;
        this.head = head;
        this.tail = tail;
        int distance = Math.abs(head.getBlock().getId() - tail.getBlock().getId());
        this.weigh = new Weight(distance);
    }


}