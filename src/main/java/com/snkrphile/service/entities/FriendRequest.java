package com.snkrphile.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class FriendRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String from;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public String getFrom() {
        return from;
    }

    public User getUser() {
        return user;
    }

}
