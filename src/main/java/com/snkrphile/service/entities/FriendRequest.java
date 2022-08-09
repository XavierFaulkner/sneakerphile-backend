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

    private String fromUser;

    private Long alertId;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public FriendRequest(String fromUser, User user) {
        this.fromUser = fromUser;
        this.user = user;
    }

    public String getFromUser() {
        return fromUser;
    }

    public User getUser() {
        return user;
    }

}
