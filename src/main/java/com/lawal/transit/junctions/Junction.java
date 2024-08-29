package com.lawal.transit.junctions;

import com.lawal.transit.blocks.interfaces.*;
import com.lawal.transit.roads.*;
import com.lawal.transit.roads.interfaces.*;

public final record Junction (
    int id,
    Avenue avenue,
    Street street,
    RoadSectional northBranch,
    RoadSectional northEastBranch,
    RoadSectional eastBranch,
    RoadSectional southEastBranch,
    RoadSectional southBranch,
    RoadSectional southWestBranch,
    RoadSectional westBranch,
    RoadSectional northWestBranch
) implements Intersectional {
//    private int id;
//    private final
//    private final ArrayList<Branchable> branches;
//
//    private Junction (Builder builder) {
//        this.id = builder.id;
//        this.branches = builder.branches;
//    }
//
//    @Override
//    public int id () {
//        return id;
//    }
//
//    @Override
//    public Avenue avenue () {
//        return null;
//    }
//
//    @Override
//    public Street street () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional northBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional northEastBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional southEastBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional southBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional southWestBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional westBranch () {
//        return null;
//    }
//
//    @Override
//    public RoadSectional northWestBranch () {
//        return null;
//    }
//
//    @Override
//    public int size () {
//        return branches.size();
//    }
//
//    @Override
//    public Iterator<Branchable> iterator () {
//        return branches.iterator();
//    }
//
//    @Override
//    public void add (Branchable branchable) throws Exception {
//        if (search(branchable.id()) != null || branches.contains(branchable))
//            throw new Exception("The branch is already exists");
//        branches.add(branches.size(), branchable);
//    }
//
//    @Override
//    public void remove (int branchId) throws Exception {
//        int index = branches.indexOf(search(branchId));
//        if (index < 0)
//            throw new Exception("Cannot remove branch which does not exist");
//    }
//
//    @Override
//    public Branchable search (int branchId) {
//        for (Branchable branchable : branches) {
//            if (branchable.id() == branchId)
//                return branchable;
//        }
//        return null;
//    }
//
//    @Override
//    public Branchable next (int currentBranchId) {
//        int currentIndex = branches.indexOf(search(currentBranchId));
//        if (currentIndex >= 0 && currentIndex < branches.size() - 1)
//            return branches.get(currentIndex + 1);
//        return null;
//    }
//
//    @Override
//    public Branchable previous (int currentBranchId) {
//        int currentIndex = branches.indexOf(search(currentBranchId));
//        if (currentIndex > 0 && currentIndex < branches.size())
//            return branches.get(currentIndex - 1);
//        return null;
//    }
//
//    private class BranchComparaor  implements Comparator<Branchable> {
//
//        @Override
//        public int compare (Branchable a, Branchable b) {
//            if (roadLabelComparison(a,b) == 0)
//                return adjacentBranchComparator(a,b);
//            if (roadLabelComparison(a,b) > 0)
//        }
//
//        private int roadLabelComparison (Branchable a,  Branchable b) {
//            return a.roadLabel().category().compareTo(b.roadLabel().category());
//        }
//
//        private int horizontalDirectionComparison ()
//
//        private int adjacentBranchComparator (Branchable a, Branchable b) {
//            return a.id() - b.id();
//        }
//    }

    public Builder builder () {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private Avenue avenue;
        private Street street;
        private RoadSectional northWestBranch;
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
            RoadSectional northBranch = street.leftFrontage().blocks().findBlock(avenue.label().id());
            RoadSectional southBranch = street.rightFrontage().blocks().findBlock(avenue.label().id());
            RoadSectional westBranch = avenue.leftFrontage().blocks().findBlock(street.label().id());
            RoadSectional eastBranch = avenue.rightFrontage().blocks().findBlock(street.label().id());
            RoadSectional turnNorthEastBranch = avenue.rightFrontage().blocks().findBlock(street.label().id() + 1);
            RoadSectional turnNorthWestBranch = avenue.leftFrontage().blocks().findBlock(street.label().id() + 1);
            RoadSectional turnSouthWestBranch = street.leftFrontage().blocks().findBlock(avenue.label().id() + 1);
            RoadSectional turnSouthEastBranch = avenue.leftFrontage().blocks().findBlock(street.label().id());
            return new Junction(
                id,
                avenue,
                street,
                northBranch,
                northEastBranch,
                eastBranch,
                southEastBranch,
                southBranch,
                southWestBranch,
                westBranch,
                northWestBranch
            );
        }
    }
}
