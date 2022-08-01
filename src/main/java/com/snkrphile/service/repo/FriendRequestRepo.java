package com.snkrphile.service.repo;

import com.snkrphile.service.entities.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendRequestRepo extends JpaRepository<FriendRequest, Long> {
    Optional<FriendRequest> findById(Long id);
}
