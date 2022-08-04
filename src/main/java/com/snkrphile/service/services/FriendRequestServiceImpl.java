package com.snkrphile.service.services;

import com.snkrphile.service.entities.FriendRequest;
import com.snkrphile.service.repo.FriendRequestRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class FriendRequestServiceImpl implements FriendRequestService{

    private final FriendRequestRepo friendRequestRepo;

    @Override
    public FriendRequest saveFriendRequest(FriendRequest friendRequest) {
        return friendRequestRepo.save(friendRequest);
    }

    @Override
    public Optional<FriendRequest> findById(Long id) {
        return friendRequestRepo.findById(id);
    }

    @Override
    public void deleteRequest(FriendRequest request) {
        friendRequestRepo.delete(request);
    }
}
