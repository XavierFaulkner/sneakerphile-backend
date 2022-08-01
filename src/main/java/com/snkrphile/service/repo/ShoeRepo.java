package com.snkrphile.service.repo;

import com.snkrphile.service.domain.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoeRepo extends JpaRepository<Shoe, Long> {
    @Override
    Optional<Shoe> findById(Long id);
}
