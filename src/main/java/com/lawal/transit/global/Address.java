package com.lawal.transit.global;

import com.lawal.transit.block.BlockTag;

public record Address(int id, String name, BlockTag blockTag) {

    @Override
    public String toString () {
        return " name:" + name + " blockTag:" + blockTag.toString();
    }

    public Builder builder () {
        return new Builder();
    }

    public static class Builder  {

        private int id;
        private String name;
        private BlockTag blockTag;

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder blockTag (BlockTag blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public Address build () {
            return new Address(id, name, blockTag) ;
        }
    }
}