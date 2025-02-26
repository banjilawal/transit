package com.lawal.transit.motion;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.TurnCategory;
import com.lawal.transit.junction.Junction;
import com.lawal.transit.road.Curb;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadRule {
    private Block currentBlock;
    private Junction junction;
    private TurnCategory turn;


//    public Block getWayPoint () {
//        switch (turn) {
//            case NO_TURN: return currentBlock.getCurb().getBlocks().findById(currentBlock.getId() + 1);
//            case REVERSE:
//        }
//    }
//
//    private Curb getOppositeCurb () {
//
//    }
}