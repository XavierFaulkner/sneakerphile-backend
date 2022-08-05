package com.snkrphile.service.repo;

import com.snkrphile.service.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlertRepo extends JpaRepository<Alert, Long> {
    Optional<Alert> findById(Long id);
}
