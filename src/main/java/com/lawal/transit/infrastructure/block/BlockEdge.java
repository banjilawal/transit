package com.lawal.transit.infrastructure.block;

import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.infrastructure.street.Street;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "block_edges")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BlockEdge {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "head_id", nullable = false)
    private Block head;

    @ManyToOne
    @JoinColumn(name = "tail_id", nullable = false)
    private Block tail;

    @Column(nullable = false)
    private Integer weight = 1; // Default to 1

    public BlockEdge(Long id,Block head, Block tail) {
        this(id, head, tail, 1);
    }

    public BlockEdge(Long id, Block head, Block tail, Integer weight) {
        if(head == null || tail == null)
            throw new NullPointerException("BlockEdge constructor cannot receive null parameters");
        if(head.equals(tail)) throw new IllegalArgumentException("head and tail blocks cannot be the same");

        this.id = id;

//        System.out.println("block head" + head);
//        System.out.println("block tail" + tail);

        setHead(head);
        setTail(tail);

        if(weight == null) weight = 1;
        this.weight = weight;
    }

    public void setHead(Block head) {
        if (head == null) {
            throw new IllegalArgumentException("Head block cannot be null");
        }
        if (head.equals(this.tail)) {
            throw new IllegalArgumentException("Head and tail blocks cannot be the same");
        }

        // Remove this edge from the old head's outgoingEdges
        if (this.head != null) {
            this.head.removeOutgoingEdge(this);
        }

        this.head = head;

        // Add this edge to the new head's outgoingEdges
        if (!this.head.getOutgoingEdges().contains(this)) {
            this.head.addOutgoingEdge(this);
        }
    }

    public void setTail(Block tail) {
        if (tail == null) {
            throw new IllegalArgumentException("Tail block cannot be null");
        }
        if (tail.equals(this.head)) {
            throw new IllegalArgumentException("Head and tail blocks cannot be the same");
        }

        // Remove this edge from the old tail's incomingEdges
        if (this.tail != null) {
            this.tail.removeIncoming(this);
        }

        this.tail = tail;

        // Add this edge to the new tail's incomingEdges
        if (!this.tail.getIncomingEdges().contains(this)) {
            this.tail.addIncomingEdge(this);
        }
    }

    public boolean containsCurb(Curb curb) {
        if (curb == null) return false;
        if (head == null || tail == null) return false;

        if (head.getCurb() != null && head.getCurb().equals(curb)) return true;
        return tail.getCurb() != null && tail.getCurb().equals(curb);
    }

    public boolean containsStreet(Street street) {
        if (street == null) return false;
        if (head == null || tail == null) return false;
        if (head.getStreet() == null && tail.getStreet() == null) return false;

        if (head.getStreet() != null && head.getStreet().equals(street)) return true;
        return tail.getStreet() != null && tail.getStreet().equals(street);
    }

    public boolean containsAvenue(Avenue avenue) {
        if (avenue == null) return false;
        if (head == null || tail == null) return false;
        if (head.getAvenue() == null && tail.getAvenue() == null) return false;

        if (head.getAvenue() != null && head.getAvenue().equals(avenue)) return true;
        return tail.getAvenue() != null && tail.getAvenue().equals(avenue);
    }

    public boolean containsBlock(Block block) {
        if (block == null) return false;
        if (head == null || tail == null) return false;
        return block.equals(this.head) || block.equals(tail);
    }

}