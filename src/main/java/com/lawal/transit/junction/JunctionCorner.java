package com.lawal.transit.junction;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.Street;
import lombok.*;

import java.util.Iterator;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class JunctionCorner {
    private final Direction orientation;
    private final Avenue avenue;
    private final Street street;

    public Block getAvenueLeg () {
        if (orientation == Direction.NORTHEAST)
            return blockFinder(avenue.rightCurb(), street.label().id());
        if (orientation == Direction.NORTHWEST)
            return blockFinder(avenue.rightCurb(), street.label().id() + 1);
        if (orientation == Direction.SOUTHEAST)
            return blockFinder(avenue.leftCurb(), street.label().id());
        return blockFinder(avenue.leftCurb(), street.label().id() + 1);
    }

    public Block getStreetLeg () {
        if (orientation == Direction.NORTHEAST)
            return blockFinder(street.rightCurb(), avenue.label().id());
        if (orientation == Direction.NORTHWEST)
            return blockFinder(street.rightCurb(), avenue.label().id() + 1);
        if (orientation == Direction.SOUTHEAST)
            return blockFinder(street.leftCurb(), avenue.label().id());
        return blockFinder(street.leftCurb(), avenue.label().id() + 1);
    }

    private Block blockFinder (Curb curb, int ceiling) {
        int counter = 0;
        Iterator<Block> iterator = curb.getBlocks().iterator();
        Block block = null;
        while (iterator.hasNext() && counter < ceiling) {
            block = iterator.next();
            counter++;
        }
        return block;
    }
}