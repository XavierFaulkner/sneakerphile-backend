package com.snkrphile.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class TradeOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String fromUser;
    private Long shoeOne;
    private Long shoeTwo;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public String getFromUser() {
        return fromUser;
    }

    public User getUser() {
        return user;
    }

    public Long getShoeOne() {
        return shoeOne;
    }

    public Long getShoeTwo() {
        return shoeTwo;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
