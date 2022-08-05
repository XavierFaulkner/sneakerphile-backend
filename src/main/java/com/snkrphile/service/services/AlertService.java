package com.snkrphile.service.services;

import com.snkrphile.service.entities.Alert;

import java.util.Optional;

public interface AlertService {
    Alert saveAlert(Alert alert);
    Optional<Alert> findById(Long id);
    void deleteAlert(Alert alert);
}
