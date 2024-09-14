package com.lawal.transit.junctions;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.*;

public record Junction (
    int id,
    Avenue avenue,
    Street street,
    RoadSectional northBranch,
    RoadSectional eastBranch,
    RoadSectional southBranch,
    RoadSectional westBranch,
    RoadSectional turnNorthEastBranch,
    RoadSectional turnSouthEastBranch,
    RoadSectional turnSouthWestBranch,
    RoadSectional turnNorthWestBranch
) implements Intersectional {

    @Override
    public String toString() {
        return getClass().getSimpleName() + " id:" + id + " " + avenue.label().name() + " and " + street.label().name();
    }

    public Builder builder () {
        return new Builder();
    }

    public static class Builder {

        private int id;
        private Avenue avenue;
        private Street street;

        public Builder () {}

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder avenue (Avenue avenue) {
            this.avenue = avenue;
            return this;
        }

        public Builder street (Street street) {
            this.street = street;
            return this;
        }

        public Junction build () {
            RoadSectional northBranch = street.leftCurb().blocks().findBlock(avenue.label().id());
            RoadSectional southBranch = street.rightCurb().blocks().findBlock(avenue.label().id());
            RoadSectional westBranch = avenue.leftCurb().blocks().findBlock(street.label().id());
            RoadSectional eastBranch = avenue.rightCurb().blocks().findBlock(street.label().id());
            RoadSectional turnNorthEastBranch = avenue.rightCurb().blocks().findBlock(street.label().id() + 1);
            RoadSectional turnNorthWestBranch = avenue.leftCurb().blocks().findBlock(street.label().id() + 1);
            RoadSectional turnSouthWestBranch = street.leftCurb().blocks().findBlock(avenue.label().id() + 1);
            RoadSectional turnSouthEastBranch = avenue.leftCurb().blocks().findBlock(street.label().id());

            return new Junction(
                id,
                avenue,
                street,
                northBranch,
                eastBranch,
                southBranch,
                westBranch,
                turnNorthEastBranch,
                turnSouthEastBranch,
                turnSouthWestBranch,
                turnNorthWestBranch
            );
        }
    }
}