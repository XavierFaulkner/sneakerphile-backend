package com.snkrphile.service.dto;

import lombok.Data;

@Data
public class AlertDto {
    private Long id;
    private String title;
    private String type;
    private String fromUsername;
    private int numOfCollections;
    private int numOfShoes;
    private int numOfFollowers;
    private int numOfFollowing;
}
