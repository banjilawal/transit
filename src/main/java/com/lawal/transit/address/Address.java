package com.lawal.transit.address;

import com.lawal.transit.block.Block;
import com.lawal.transit.block.BlockTag;

public record Address(int id, String name, Block block, BlockTag blockTag) {

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id +  " mailing:" + name + " " + block.getCurb().toString();
    }

    public Builder builder () {
        return new Builder();
    }

    public static class Builder  {

        private int id;
        private String name;
        private Block block;
        private BlockTag blockTag;

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder name (String name) {
            this.name = name;
            return this;
        }

        public Builder block (Block block) {
            this.block = block;
            return this;
        }

        public Builder blockTag (BlockTag blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public Address build () {
            return new Address(id, name, block, blockTag) ;
        }
    }
}