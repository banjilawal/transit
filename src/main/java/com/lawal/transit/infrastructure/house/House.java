package com.lawal.transit.infrastructure.house;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.curb.exception.CurbOrientationException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "houses")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class House {

    @Id
    @EqualsAndHashCode.Include
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
//        if (block == null)throw new NullBlockException(HouseMessage.BLOCK_PARAMETER_NULL_EXCEPTION);

        if (this.block == block) return;

        if (this.block != null) {
            this.block.removeHouse(this); // Avoid direct access; use a dedicated method
        }

        this.block = block;
        block.addHouse(this);
    }

    @Override
    public String toString () {
        String roadName = block.getCurb().getRoadName() + " " + block.getCurb().getOrientation().print();
        return address + " " + roadName;
//        return getClass().getSimpleName() + "[id:" + id
//            + " mailing:" + address + " "
//            + block.getCurb().getRoadName()
//            + " " + block.getCurb().getOrientation().abbreviation(); // + " " + block.getCurb().toString();
    }
}