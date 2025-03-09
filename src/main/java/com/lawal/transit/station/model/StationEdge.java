package com.lawal.transit.station.model;

import com.lawal.transit.station.model.exception.NullStationException;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "edges")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StationEdge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "head_station_id", nullable = false)
    private Station head;

    @ManyToOne
    @JoinColumn(name = "tail_station_id", nullable = false)
    private Station tail;

    @Column(name = "distance", nullable = false, columnDefinition = "int default 0")
    private int distance;

    @Column(name = "actual_time", nullable = false, columnDefinition = "int default 0")
    private int actual_time;

    @Column(name = "heuristic", nullable = false, columnDefinition = "int default 0")
    private int heuristic;

    public StationEdge (Long id, Station head, Station tail, int distance, int actual_time, int heuristic) {

        if (head == null || tail == null) {
            throw new NullStationException(NullStationException.MESSAGE);
        }

        if (head.getOutgoingEdges() == null || tail.getIncomingEdges() == null) {
            throw new IllegalArgumentException("Neither head nor tail stations can have null outgoing or incoming edge lists");
        }

        if (distance < 0 || actual_time < 0 || heuristic < 0) {
            throw new IllegalArgumentException("StationEdge distance, actual_time, nor heuristic can be negative");
        }

        this.head = head;
        if (!this.head.getOutgoingEdges().contains(this)) this.head.getOutgoingEdges().add(this);

        this.tail = tail;
        if (!this.tail.getIncomingEdges().contains(this)) this.tail.getIncomingEdges().add(this);

        this.id = id;
        this.distance = distance;
        this.heuristic = heuristic;
        this.actual_time = actual_time;
    }

    public int getWeight () { return distance + actual_time; }

    public void setHead (Station station) {
        if (station == null) throw new NullStationException(NullStationException.MESSAGE);

        if (this.head != null && this.head.equals(station)) return;

        if (this.head != null) {
            this.head.getOutgoingEdges().remove(this);
            this.head = null;
        }

        this.head = station;
        this.head.getOutgoingEdges().add(this);
    }

    public void setTail(Station station) {
        if (station == null) throw new NullStationException(NullStationException.MESSAGE);
        if (this.tail != null && this.tail.equals(station)) return;

        if (this.tail != null) {
            this.tail.getIncomingEdges().remove(this);
            this.tail = null;
        }

        this.tail = station;
        this.tail.getOutgoingEdges().add(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id
            + " head:("
            + head.getName()
            + head.getBlock().getCurb().getOrientation()
            + " inDegree:" + head.getIncomingEdges().size()
            + " outDegree:" + head.getOutgoingEdges().size()
            + ")"
        +
            " tail:("
            + tail.getName()
            + tail.getBlock().getCurb().getOrientation()
            + " inDegree:" + tail.getIncomingEdges().size()
            + " outDegree:" + tail.getOutgoingEdges().size()
            + ")"
            + " distance:" + distance + " actual_time:" + actual_time + " heuristic:" + heuristic + "]";
    }
}