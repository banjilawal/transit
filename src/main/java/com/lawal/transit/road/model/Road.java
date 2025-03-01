package com.lawal.transit.road.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.lane.model.Lane;
import com.lawal.transit.street.model.Street;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roads")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Road {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Avenue avenue;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Street street;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Curb leftCurb;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Curb rightCurb;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Lane leftLane;

    @OneToOne(mappedBy = "road", cascade = CascadeType.ALL, orphanRemoval = true)
    private Lane rightLane;

    @OneToMany(mappedBy = "road", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lane> lanes = new ArrayList<>();

    public Road (Long id) { this.id = id; }

    public void setStreet(Street street) {
        if (this.street != null && this.street.equals(street)) return;

        this.street = street;
        if (street.getRoad() != this) { this.street.setRoad(this); }
    }

    public void setAvenue(Avenue avenue) {
        if (this.avenue != null && this.avenue.equals(avenue)) return;

        this.avenue = avenue;
        if (avenue.getRoad() != this) { this.avenue.setRoad(this); }
    }

    @Override
    public String toString() {
        String avenueString = avenue == null ? "" : avenue.toString();
        String streetString = street == null ? "" : street.toString();
        return getClass().getSimpleName() + "[roadId:" + id + " " + avenueString + " " + streetString +"]";
    }
}