package com.lawal.transitcraft.infrastructure.bus;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@Table(name = "departure_legs")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DepartureLeg {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "head_head_id", nullable = false)
    private Departure head;

    @ManyToOne
    @JoinColumn(name = "tail_departure_id", nullable = false)
    private Departure tail;

}