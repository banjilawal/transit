package com.lawal.transit.block.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BlockEdge {

    @Id
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

    public BlockEdge(Block head, Block tail, Integer weight) {
        if(head == null || tail == null)
            throw new NullPointerException("BlockEdge constructor cannot receive null parameters");
        if(head.equals(tail)) throw new IllegalArgumentException("head and tail blocks cannot be the same");

        if(weight == null) weight = 1;

        this.head = head;
        if (!this.head.getOutgoingEdges().contains(this)) this.head.getOutgoingEdges().add(this);

        this.tail = tail;
        if (!this.head.getOutgoingEdges().contains(this)) this.head.getOutgoingEdges().add(this);

        this.weight = weight;
    }

    public void setHead(Block head) {
        if (head != null && head.equals(this.tail)) return;

        if(this.head != null) {
            this.head.getOutgoingEdges().remove(this);
        }

        this.head = head;
        if(this.head != null && !this.head.getOutgoingEdges().contains(this)) this.head.getOutgoingEdges().add(this);
    }

    public void setTail(Block tail) {
        if(tail != null && tail.equals(this.tail)) return;

        if(this.tail != null) {
            this.tail.getIncomingEdges().remove(this);
        }
        this.tail = tail;
        if(this.tail != null && !this.tail.getIncomingEdges().contains(this)) this.tail.getIncomingEdges().add(this);
    }

}