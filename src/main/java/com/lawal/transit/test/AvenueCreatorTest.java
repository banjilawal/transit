package com.lawal.transit.test;

import com.lawal.transit.global.NameGenerator;
import com.lawal.transit.road.*;
import com.lawal.transit.road.creators.RoadBuilder;

public class AvenueCreatorTest {

    public static void main(String[] args) throws Exception {

        RoadBuilder roadBuilder = new RoadBuilder()
            .numberOfBlocks(5)
            .placesPerBlock(4)
            .placeNameInterval(2);

        Avenue avenue = (Avenue) roadBuilder.roadCategory(RoadCategory.AVENUE)
            .roadName("alpha")
            .roadId(1)
            .getProduct();

        Street street = (Street) roadBuilder.roadCategory(RoadCategory.STREET)
            .roadName(NameGenerator.INSTANCE.streetName(3))
            .roadId(1)
            .getProduct();

        System.out.println(avenue.leftCurb().toString() + "\n" + avenue.rightCurb().toString());
        System.out.println(street.leftCurb().toString() + "\n" + street.rightCurb().toString());


//        RoadIdentifier roadLabel = new RoadLabel(IdGenerator.INSTANCE.nextAvenueId(), NameGenerator.INSTANCE.avenueName(), Avenue.ROAD_CATEGORY);
//        Avenue avenue = new Avenue(roadLabel);
//        int roadId = IdGenerator.INSTANCE.nextAvenueId();
//        AddressingSet addressingSet = new AddressingSet(
//            roadId * Constant.MULTIPLICATION_FACTOR,
//            roadId * Constant.MULTIPLICATION_FACTOR + 1,
//            Avenue.LEFTWARD_CURB_ID,
//            Avenue.RIGHTWARD_CURB_ID
//        );
//        RoadParameters roadParameters = new RoadParameters.Builder()
//            .roadId(roadId)
//            .roadName(NameGenerator.INSTANCE.avenueName())
//            .roadCategory(Avenue.ROAD_CATEGORY)
//            .addressInterval(Constant.ADDRESS_INTERVAL)
//            .blocksPerFrontage(4)
//            .placesPerBlock(4)
//            .addressingSet(addressingSet)
//            .multiplicationFactor(Constant.MULTIPLICATION_FACTOR)
//            .stationInterval(2)
//            .build();
//            System.out.println(roadParameters.toString());
//
//        AvenueCreator avenueCreator = new AvenueCreator(roadParameters);
//        Avenue avenue = avenueCreator.create();
//        System.out.println(avenue.toString() + "\n" + avenue.leftCurb().toString() + "\n" + avenue.rightCurb().toString());
//
//        roadId = IdGenerator.INSTANCE.nextStreetId();
//        addressingSet = new AddressingSet(
//                roadId * Constant.MULTIPLICATION_FACTOR,
//                roadId * Constant.MULTIPLICATION_FACTOR + 1,
//                Street.LEFTWARD_STATION_BASE_NAME,
//                Street.RIGHTWARD_STATION_BASE_NAME
//        );
//        roadParameters = new RoadParameters.Builder()
//                .roadId(roadId)
//                .roadName(NameGenerator.INSTANCE.streetName())
//                .roadCategory(Street.ROAD_CATEGORY)
//                .addressInterval(Constant.ADDRESS_INTERVAL)
//                .blocksPerFrontage(10)
//                .placesPerBlock(3)
//                .addressingSet(addressingSet)
//                .multiplicationFactor(Constant.MULTIPLICATION_FACTOR)
//                .stationInterval(4)
//                .build();
//        System.out.println(roadParameters.toString());
//        StreetCreator streetCreator = new StreetCreator(roadParameters);
//        Street street = streetCreator.create();
//        System.out.println(street.toString() + "\n" + street.leftCurb().toString() + "\n" + street.rightCurb().toString());
//        avenue.leftCurb().blocks().addBlock(new Block.Builder().tag(new BlockTag(1, avenue.leftCurb().address())).places(new Places()).build());
//        System.out.println(avenue.leftCurb().toString());

//        Curbsideable curbside = new Curbside.Builder()
//            .address(new CurbsideMark(avenue.label(), Avenue.LEFTWARD_TRAFFIC_DIRECTION))
//            .blocks(new Blocks()).stations(new Stations()).build();
//        System.out.println(curbside.toString());

//        Avenue avenue = new Avenue.Builder()
//            .label(new RoadLabel.Builder().id(1).category(Avenue.ROAD_CATEGORY).name("Alpha")).build()
//                .rightCurb(new Curbside.Builder())


//
//        AvenueCreator avenueCreator = new AvenueCreator(roadParameters);
//        Avenue avenue = avenueCreator.create();
//

    }
}