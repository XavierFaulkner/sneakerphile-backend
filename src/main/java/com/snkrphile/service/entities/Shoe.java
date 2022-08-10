package com.snkrphile.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Shoe {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String size;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="closet_id", referencedColumnName = "id")
    private Closet closet;

    public void assignCloset(Closet closet) {
        this.closet = closet;
    }
}
