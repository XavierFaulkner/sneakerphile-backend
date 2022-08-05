package com.snkrphile.service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String title;

    private String fromUser;

    private String type;

    private Long shoeOne;

    private Long shoeTwo;

    public Alert(String title, String type, String fromUser, User sendTo) {
        this.title = title;
        this.type = type;
        this.fromUser = fromUser;
        shoeOne = null;
        shoeTwo = null;
        user = sendTo;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
}
