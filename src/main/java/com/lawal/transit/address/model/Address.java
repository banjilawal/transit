package com.lawal.transit.address.model;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.block.model.exception.NullBlockException;
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
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    public Address (Long id, String name, Block block) {
        this.id = id;
        this.name = name;
        setBlock(block);
        this.block.getAddresses().add(this);
    }

    public void setBlock(Block block) {
//        if (block == null)throw new NullBlockException(AddressMessage.BLOCK_PARAMETER_NULL_EXCEPTION);

        if (this.block == block) return;

        if (this.block != null) {
            this.block.removeAddress(this); // Avoid direct access; use a dedicated method
        }

        this.block = block;
        block.addAddress(this);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " mailing:" + name; // + " " + block.getCurb().toString();
    }
}