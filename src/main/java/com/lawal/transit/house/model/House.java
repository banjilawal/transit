package com.lawal.transit.house.model;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.CurbOrientationException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "places")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = CurbOrientationException.MESSAGE)
    Long address;

    @ManyToOne
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    public House (Long id, Long address, Block block) {
        this.id = id;
        this.address = address;

        setBlock(block);
        this.block.getHouses().add(this);
    }

    public void setBlock(Block block) {
//        if (block == null)throw new NullBlockException(AddressMessage.BLOCK_PARAMETER_NULL_EXCEPTION);

        if (this.block == block) return;

        if (this.block != null) {
            this.block.removeHouse(this); // Avoid direct access; use a dedicated method
        }

        this.block = block;
        block.addHouse(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " mailing:" + address + " " + block.getCurb().getRoadName() + " " + block.getCurb().getOrientation().abbreviation(); // + " " + block.getCurb().toString();
    }
}