package com.snkrphile.service.repo;

import com.snkrphile.service.entities.Closet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClosetRepo extends JpaRepository<Closet, Long> {
    Optional<Closet> findById(Long id);
}
