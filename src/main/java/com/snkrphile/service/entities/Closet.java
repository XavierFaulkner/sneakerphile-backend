package com.snkrphile.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Closet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;

    private Boolean hidden = false;
    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL)
    private Collection<Shoe> shoes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public User getUser() {
        return user;
    }

    public void assignUser(User user) {
        this.user = user;
    }
}
