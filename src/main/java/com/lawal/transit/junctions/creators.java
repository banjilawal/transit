package com.lawal.transit.junctions;

import com.lawal.transit.globals.IdGenerator;
import com.lawal.transit.roads.Avenue;
import com.lawal.transit.roads.Avenues;
import com.lawal.transit.roads.Street;
import com.lawal.transit.roads.Streets;

public class creators {
    public static class JunctionFactory {

        private Avenues avenues;
        private Streets streets;

        public JunctionFactory() {

        }

        public Avenues getAvenues () {
            return avenues;
        }

        public Streets getStreets () {
            return streets;
        }

        public JunctionFactory avenues (Avenues avenues) {
            this.avenues = avenues;
            return this;
        }

        public JunctionFactory streets (Streets streets) {
            this.streets = streets;
            return this;
        }

        public Junctions getProduct () throws Exception {
            Junctions junctions = new Junctions();
            for (Avenue avenue : avenues.getAvenues()) {
                for (Street street : streets.getStreets()) {
                    junctions.add(
                        new Junction.Builder()
                            .id(IdGenerator.INSTANCE.nextJunctionId())
                            .avenue(avenue)
                            .street(street)
                            .build()
                    );
                }

            }
            return junctions;
        }
    }
}