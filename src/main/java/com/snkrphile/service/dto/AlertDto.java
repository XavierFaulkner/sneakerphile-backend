package com.snkrphile.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AlertDto {
    private Long id;
    private Long requestId;
    private String title;
    private String type;
    private Date userSince;
    private int numOfCollections;
    private int numOfShoes;
    private int numOfFollowers;
    private int numOfFollowing;
}
