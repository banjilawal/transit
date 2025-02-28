package com.lawal.transit.address.model;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.CurbOrientationException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = CurbOrientationException.MESSAGE)
    String name;

    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;


    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " mailing:" + name + " " + block.getCurb().toString();
    }
}