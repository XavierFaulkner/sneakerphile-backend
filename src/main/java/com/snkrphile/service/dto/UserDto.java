package com.snkrphile.service.dto;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.entities.FriendRequest;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Collection<Closet> closets;
    private Collection<FriendRequest> friendRequests;
    private Collection<String> friends;
    private Collection<String> friendsOf;
    private int numOfClosets;
    private int numOfFollowers;
    private int numOfFollowing;
}
