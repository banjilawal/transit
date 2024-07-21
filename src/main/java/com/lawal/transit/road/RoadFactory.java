package com.lawal.transit.road;

public final class RoadFactory implements RoadFactoryInterface {

    private final int id;
    private final String name;
    private final RoadCategory category;
//    private final int numberOfRightLanes;
//    private final int numberOfLeftLanes;
    private Avenue avenue;
    private Street street;

    public RoadFactory (
        int id,
        String name,
        RoadCategory category,
        int numberOfRightLanes,
        int numberOfLeftLanes
    ) throws Exception {
        this.id = id;
        this.name = name;
//        this.numberOfRightLanes = numberOfRightLanes;
//        this.numberOfLeftLanes = numberOfLeftLanes;
        this.category = category;
        switch (category) {
            case AVENUE -> {
                this.street = null;
                this.avenue = new Avenue(id, name); //, numberOfRightLanes, numberOfLeftLanes);
            }
            case STREET -> {
                this.avenue = null;
                this.street = new Street(id, name); //, numberOfRightLanes, numberOfLeftLanes);
            }
        }
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public Avenue getAvenue () {
        return avenue;
    }

    @Override
    public Street getStreet () {
        return street;
    }

//    @Override
//    public int getNumberOfRightLanes () {
//        return numberOfRightLanes;
//    }
//
//    @Override
//    public int getNumberOfLeftLanes () {
//        return numberOfLeftLanes;
//    }


    @Override
    public RoadCategory getCategory () {
        return category;
    }

}
