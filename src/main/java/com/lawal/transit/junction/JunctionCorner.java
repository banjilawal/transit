package com.lawal.transit.junction;

import com.lawal.transit.block.Block;
import com.lawal.transit.catalog.AvenueCatalog;
import com.lawal.transit.catalog.CurbCatalog;
import com.lawal.transit.catalog.StreetCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.Avenue;
import com.lawal.transit.road.Curb;
import com.lawal.transit.road.Street;

public class JunctionCorner {

    private final int id;
    private final String name;
    private final Direction cornerOrientation;
    private final Junction junction;

    private Block avenueLeg;
    private Block streetLeg;

    public JunctionCorner(int id, Junction junction, Direction cornerOrientation) {
        this.id = id;
        this.junction = junction;
        if (isValidOrientation(cornerOrientation))
            this.cornerOrientation = cornerOrientation;
        else throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);
        setAvenueLeg();
        getStreetCurb();
        setStreetLeg();
        this.name = this.cornerOrientation.name() + " Corner";

    }

    public int getId() { return id; }

    public String getName() { return name; }

    public Direction getCornerOrientation() { return cornerOrientation; }

    public Junction getJunction() { return junction; }



//    public Block getAvenueLeg() { return avenueLeg; }
//
//    public Block getStreetLeg() { return streetLeg; }

    private void setAvenueLeg() {
        int streetId = junction.street().getId();
        int avenueId = junction.avenue().getId();
        Avenue avenue = junction.avenue();
        Street street = junction.street();

//        System.out.println("avenuedId:" + avenueId + " arrayIndex:" + AvenueCatalog.INSTANCE.getCatalog().getAvenues().indexOf(avenue));
//        System.out.println("streetId:" + streetId + " arrayIndex:" + StreetCatalog.INSTANCE.getCatalog().getStreets().indexOf(street));
        Curb avenueCurb = getAvenueCurb();
        int avenueLength = avenueCurb.getBlocks().size();
            switch (cornerOrientation) {
            case NORTHWEST -> this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1);
            case NORTHEAST -> {
                if (streetId < avenueLength) {
                    this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId);
                } else this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1);
            }
            case SOUTHWEST -> this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1);
            case SOUTHEAST -> {
                if (streetId < avenueLength) { this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId);}
                else { this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1); }
            }
            default -> {
                System.out.println("Invalid corner orientation: " + cornerOrientation);
                this.avenueLeg = null;
            }
        }
        System.out.println("avenueLeg:" + avenueLeg.toString() + " avenue_curb_arrayIndex:" + avenueCurb.getBlocks().getList().indexOf(avenueLeg) + " cornerId:" + id + " cornerOrientation:" + cornerOrientation.print() + "");
    }

    private void setStreetLeg() {
        int streetId = junction.street().getId();
        int avenueId = junction.avenue().getId();

        Street street = junction.street();
        Avenue avenue = junction.avenue();
//        System.out.println("avenuedId:" + avenueId + " arrayIndex:" + AvenueCatalog.INSTANCE.getCatalog().getAvenues().indexOf(avenue));
//        System.out.println("streetId:" + streetId + " arrayIndex:" + StreetCatalog.INSTANCE.getCatalog().getStreets().indexOf(street));
        Curb streetCurb = getStreetCurb();
        int streetLength = streetCurb.getBlocks().size();
        switch (cornerOrientation) {
            case NORTHWEST -> this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1);
            case NORTHEAST -> {
                if (avenueId < streetLength) {
                    this.streetLeg = streetCurb.getBlocks().getList().get(avenueId);
                } else this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1);
            }
            case SOUTHWEST -> this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1);
            case SOUTHEAST -> {
                if (avenueId < streetLength) { this.streetLeg = streetCurb.getBlocks().getList().get(avenueId);}
                else { this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1); }
            }
            default -> {
                System.out.println("Invalid corner orientation: " + cornerOrientation);
                this.streetLeg = null;
            }
        }
        System.out.println("streetLeg:" + streetLeg.toString() + " street_curb_arrayIndex:" + streetCurb.getBlocks().getList().indexOf(streetLeg) + " cornerId:" + id + " cornerOrientation:" + cornerOrientation.print() + "");
    }

    private boolean isValidOrientation(Direction cornerOrientation) {
        return cornerOrientation == Direction.NORTHEAST ||
            cornerOrientation == Direction.SOUTHEAST ||
            cornerOrientation == Direction.SOUTHWEST ||
            cornerOrientation == Direction.NORTHWEST;
    }

//    private Block blockFinderUtility(Curb targetCurb, int crossRoadId) {
//        if (targetCurb == null) {
//            System.err.println("Target curb is null. Cannot find blocks!");
//            return null; // Return null if the target curb is not available
//        }
//
//        if (targetCurb.getBlocks() == null || targetCurb.getBlocks().size() == 0) {
//            System.err.println("No blocks found on the curb: " + targetCurb.toString());
//            return null; // Return null if the curb has no blocks
//        }
//
//        // Ensure the id falls within the valid range
////        if (crossRoadBlockId < 0 || crossRoadBlockId >= targetCurb.getBlocks().size()) {
////            System.err.println("Invalid block ID: " + crossRoadBlockId + ". Range is [0, "
////                + (targetCurb.getBlocks().size() - 1) + "]");
////            return null;
////        }
//        Block block = null;
//        for (int i = 0; i < crossRoadId; i++) {
//            block = targetCurb.getBlocks().getList().get(i);
//        }
//        return block; // Return the block if no issues
//    }

    public Avenue getAvenue() { return junction.avenue(); }

    public Street getStreet() { return junction.street(); }

    public Curb getAvenueCurb() {
        if (junction.avenue() == null) {
            throw new IllegalStateException("Junction has no associated avenue");
        }

        Curb curb = null;
        if (cornerOrientation == Direction.NORTHEAST || cornerOrientation == Direction.NORTHWEST)
            curb = junction.avenue().getCurbByOrientation(Direction.NORTH);
        else
            curb = junction.avenue().getCurbByOrientation(Direction.SOUTH);
        if (curb == null) {
            System.err.println("cornerId:" + id + " Warning: No curb found for corner orientation " + cornerOrientation);
        }
//        else {
//            System.out.println("Found ave Curb: " + curb.toString());
//        }
//        System.out.println(curb.toString() + " curbArrayIndex:" + CurbCatalog.INSTANCE.getCatalog().getCurbs().indexOf(curb));
//        for (Block block : curb.getBlocks().getList()) {
//            System.out.println("blockId:" + block.getId() + " curbArrayIndex:" + curb.getBlocks().getList().indexOf(block));
//        }
        return curb;
    }


    private Curb getStreetCurb() {
        if (junction.street() == null) {
            throw new IllegalStateException("Junction has no associated street");
        }
        Street street = junction.street();
//        System.out.println("cornerOrientation:" + cornerOrientation.print() + " street curb:" + street.leftCurb().toString() );
//        System.out.println("cornerOrientation:" + cornerOrientation.print() + " street curb:" + street.rightCurb().toString() );

        Curb curb = null;
        Direction curbOrientation = Direction.EAST;
//        if (cornerOrientation == Direction.NORTHEAST || cornerOrientation == Direction.SOUTHEAST) {
//            System.out.println("FOUND: " + street.getCurbByOrientation(curbOrientation));
//
//        }
        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation == Direction.SOUTHEAST) //{
            curbOrientation = Direction.WEST;
        curb = street.getCurbByOrientation(curbOrientation);
        return curb;
//        System.out.println("FOUND: " + curb.toString());
//            System.out.println("FOUND: " + junction.street().getCurbByOrientation(curbOrientation));
//        }
//        else
//            System.err.println("cornerId:" + id +  " Warning: No curb found for orientation " + cornerOrientation.print() + " for street: " + street.toString());
////        return curb;
    }

    @Override
    public String toString() {
        return "";
//        Curb avenueCurb = getAvenueCurb();
//        Curb streetCurb = getStreetCurb();
//        String aveCcurbString = (avenueCurb == null || avenueCurb.getOrientation() == null)
//            ? "\nave curb: NA"
//            : "\nave curb: " + avenueCurb.toString();

//        String streetCurbString = (streetCurb == null || streetCurb.getOrientation() == null)
//            ? "\nstreet curb: NA"
//            : "\nSreet curb: " + streetCurb.toString();
//        return getClass().getSimpleName()
//            + "[id:" + id
//            + " name:" + name
//            + " cornerOrientation:" + cornerOrientation;
//            + "] junctionId:" + junction.id() + " " + getAvenue().toString() + " " + junction.street().toString();
//            + " " + aveCcurbString
//            + " " + streetCurbString;
    }
}

//@Getter
//public class JunctionCorner {
//    private int id;
//    private Junction junction;
//    private final String name;
//    private final Direction cornerOrientation;
//    private final Avenue avenue;
//    private final Street street;
//
//    public JunctionCorner(Direction cornerOrientation, Avenue avenue, Street street) {
//        if (cornerOrientation == Direction.NORTH || cornerOrientation == Direction.EAST ||
//            cornerOrientation == Direction.SOUTH || cornerOrientation == Direction.WEST
//        ) {
//            throw new IllegalArgumentException("Invalid junction corner orientation: " + cornerOrientation);
//        }
//        this.cornerOrientation = cornerOrientation;
//        this.avenue = avenue;
//        this.street = street;
//        this.name = cornerOrientation.name() + "Corner";
//    }
//
//
//    public Block getAvenueLeg () {
//        if (cornerOrientation == Direction.NORTHEAST)
//            return blockFinder(avenue.rightCurb(), street.label().id());
//        if (cornerOrientation == Direction.NORTHWEST)
//            return blockFinder(avenue.rightCurb(), street.label().id() + 1);
//        if (cornerOrientation == Direction.SOUTHEAST)
//            return blockFinder(avenue.leftCurb(), street.label().id());
//        return blockFinder(avenue.leftCurb(), street.label().id() + 1);
//    }
//
//    public Block getStreetLeg () {
//        if (cornerOrientation == Direction.NORTHEAST)
//            return blockFinder(street.rightCurb(), avenue.label().id());
//        if (cornerOrientation == Direction.NORTHWEST)
//            return blockFinder(street.rightCurb(), avenue.label().id() + 1);
//        if (cornerOrientation == Direction.SOUTHEAST)
//            return blockFinder(street.leftCurb(), avenue.label().id());
//        return blockFinder(street.leftCurb(), avenue.label().id() + 1);
//    }
//
//    private Block blockFinder (Curb curb, int ceiling) {
//        int counter = 0;
//        Iterator<Block> iterator = curb.getBlocks().iterator();
//        Block block = null;
//        while (iterator.hasNext() && counter < ceiling) {
//            block = iterator.next();
//            counter++;
//        }
//        return block;
//    }
//}

//public class JunctionCorner {
//    private final Direction orientation;
//    private final Avenue avenue;
//    private final Street street;
//
//    // Predefined curb mappings based on direction
//    private static final Map<Direction, CurbType> AVENUE_CURB_MAP = Map.of(
//        Direction.NORTHEAST, CurbType.RIGHT,
//        Direction.NORTHWEST, CurbType.RIGHT,
//        Direction.SOUTHEAST, CurbType.LEFT,
//        Direction.SOUTHWEST, CurbType.LEFT
//    );
//
//    private static final Map<Direction, CurbType> STREET_CURB_MAP = Map.of(
//        Direction.NORTHEAST, CurbType.RIGHT,
//        Direction.NORTHWEST, CurbType.RIGHT,
//        Direction.SOUTHEAST, CurbType.LEFT,
//        Direction.SOUTHWEST, CurbType.LEFT
//    );
//
//    public JunctionCorner(Direction orientation, Avenue avenue, Street street) {
//        this.orientation = orientation;
//        this.avenue = avenue;
//        this.street = street;
//
//        if (!AVENUE_CURB_MAP.containsKey(orientation)) {
//            throw new IllegalArgumentException("Invalid direction for a junction corner: " + orientation);
//        }
//    }
//
//    public Block getAvenueLeg() {
//        // Use mapping to fetch appropriate curb
//        return findBlock(getAvenueCurb(), street.label().id());
//    }
//
//    public Block getStreetLeg() {
//        // Use mapping to fetch appropriate curb
//        return findBlock(getStreetCurb(), avenue.label().id());
//    }
//
//    private Curb getAvenueCurb() {
//        return AVENUE_CURB_MAP.get(orientation) == CurbType.RIGHT
//            ? avenue.rightCurb()
//            : avenue.leftCurb();
//    }
//
//    private Curb getStreetCurb() {
//        return STREET_CURB_MAP.get(orientation) == CurbType.RIGHT
//            ? street.rightCurb()
//            : street.leftCurb();
//    }
//
//    private Block findBlock(Curb curb, int ceiling) {
//        Iterator<Block> iterator = curb.getBlocks().iterator();
//        Block block = null;
//        int counter = 0;
//
//        while (iterator.hasNext() && counter < ceiling) {
//            block = iterator.next();
//            counter++;
//        }
//
//        return block;
//    }
//
//    private enum CurbType {
//        LEFT, RIGHT
//    }
//}