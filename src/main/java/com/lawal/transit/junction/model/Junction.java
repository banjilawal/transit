package com.lawal.transit.junction.model;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.street.model.Street;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "junctions")
public class Junction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    String name;

    @ManyToOne
    @JoinColumn(name = "avenue_id")
    private Avenue avenue;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "junction", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JunctionCorner> corners = new ArrayList<>();

    public Junction(Long id, Avenue avenue, Street street) {
        this.id = id;
        this.avenue = avenue;
        this.street = street;
        this.name = avenue.getName() + " Ave and " + street.getName() + " St";
        this.corners = new ArrayList<>();
    }

    public Avenue getAvenue() { return avenue; }

    public Street getStreet() { return street; }

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Junction junction) {
            return id.equals(junction.getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id + " " + avenue.getName() + " Ave and " + street.getName() + " St]";
    }
}