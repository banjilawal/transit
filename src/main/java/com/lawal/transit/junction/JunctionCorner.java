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

    public Avenue getAvenue() { return junction.avenue(); }

    public Street getStreet() { return junction.street(); }


    private void setAvenueLeg() {
        Curb avenueCurb = getAvenueCurb();
        int streetId = junction.street().getId();
        int avenueLength = avenueCurb.getBlocks().size();


        this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId - 1);

        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && streetId < avenueLength) {
            this.avenueLeg = avenueCurb.getBlocks().getList().get(streetId);
        }

        System.out.println("avenueLeg:" + avenueLeg.toString()
            + " avenue_curb_arrayIndex:" + avenueCurb.getBlocks().getList().indexOf(avenueLeg)
            + " cornerId:" + id + " cornerOrientation:"
            + cornerOrientation.print() + "");
    }

    private void setStreetLeg() {
        Curb streetCurb = getStreetCurb();
        int avenueId = junction.avenue().getId();
        int streetLength = streetCurb.getBlocks().size();

        this.streetLeg = streetCurb.getBlocks().getList().get(avenueId - 1);

        if (cornerOrientation != Direction.NORTHWEST && cornerOrientation == Direction.SOUTHWEST && avenueId < streetLength) {
            this.streetLeg = streetCurb.getBlocks().getList().get(avenueId);
        }

        System.out.println("streetLeg:" + streetLeg.toString()
            + " street_curb_arrayIndex:" + streetCurb.getBlocks().getList().indexOf(streetLeg)
            + " cornerId:" + id
            + " cornerOrientation:" + cornerOrientation.print() + "");
    }

    private boolean isValidOrientation(Direction cornerOrientation) {
        return cornerOrientation == Direction.NORTHEAST ||
            cornerOrientation == Direction.SOUTHEAST ||
            cornerOrientation == Direction.SOUTHWEST ||
            cornerOrientation == Direction.NORTHWEST;
    }

    public Curb getAvenueCurb() {
        Direction curbOrientation = Direction.NORTH;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation != Direction.NORTHWEST)
            curbOrientation = Direction.SOUTH;
        return junction.avenue().getCurbByOrientation(curbOrientation);
    }


    private Curb getStreetCurb() {
        Direction curbOrientation = Direction.EAST;

        if (cornerOrientation != Direction.NORTHEAST && cornerOrientation == Direction.SOUTHEAST)
            curbOrientation = Direction.WEST;
        return junction.street().getCurbByOrientation(curbOrientation);
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