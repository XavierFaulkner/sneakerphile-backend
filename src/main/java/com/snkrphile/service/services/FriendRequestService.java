package com.snkrphile.service.services;

import com.snkrphile.service.entities.FriendRequest;

import java.util.Optional;

public interface FriendRequestService {
    FriendRequest saveFriendRequest(FriendRequest friendRequest);
    Optional<FriendRequest> findById(Long id);
    void deleteRequest(FriendRequest request);
}
