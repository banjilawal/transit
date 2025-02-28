package com.lawal.transit.road.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.lane.model.Lane;
import com.lawal.transit.street.model.Street;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roads")
public class Road {

    @Id
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
}