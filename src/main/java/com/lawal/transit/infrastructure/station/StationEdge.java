package com.lawal.transit.infrastructure.station;

import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.infrastructure.station.exception.NullStationException;
import com.lawal.transit.infrastructure.street.Street;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "station_edges")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StationEdge {

    @Id
    @EqualsAndHashCode.Include
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


    public boolean containsCurb(Curb curb) {
        if (curb == null) return false;
        if (head == null || tail == null) return false;

        Curb headCurb = head.getBlock().getCurb();
        Curb tailCurb = tail.getBlock().getCurb();
        if (headCurb == null && tailCurb == null) return false;

        if (headCurb != null && headCurb.equals(curb)) return true;
        return tailCurb != null && tailCurb.equals(curb);
    }

    public boolean containsStreet(Street street) {
        if (street == null) return false;
        if (head == null || tail == null) return false;

        Street headStreet = head.getBlock().getCurb().getStreet();
        Street tailStreet = tail.getBlock().getCurb().getStreet();
        if (headStreet == null && tailStreet == null) return false;

        if (headStreet != null && headStreet.equals(street)) return true;
        return tailStreet != null && tailStreet.equals(street);
    }

    public boolean containsAvenue(Avenue avenue) {
        if (avenue == null) return false;
        if (head == null || tail == null) return false;

        Avenue headAvenue = head.getBlock().getCurb().getAvenue();
        Avenue tailAvenue = tail.getBlock().getCurb().getAvenue();
        if (headAvenue == null && tailAvenue == null) return false;

        if (headAvenue != null && headAvenue.equals(avenue)) return true;
        return tailAvenue != null && tailAvenue.equals(avenue);
    }

    public boolean containsBlock(Block block) {
        if (block == null) return false;
        if (head == null || tail == null) return false;

        Block headBlock = head.getBlock();
        Block tailBlock = tail.getBlock();
        if (headBlock == null && tailBlock == null) return false;

        if (headBlock != null && headBlock.equals(block)) return true;
        return tailBlock != null && tailBlock.equals(block);
    }

    public boolean containsStation (Station station) {
        if (station == null) return false;
        if (this.head == null || tail == null) return false;
        return station.equals(this.head) || station.equals(this.tail);
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