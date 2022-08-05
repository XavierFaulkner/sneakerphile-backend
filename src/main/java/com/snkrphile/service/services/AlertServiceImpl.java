package com.snkrphile.service.services;

import com.snkrphile.service.entities.Alert;
import com.snkrphile.service.repo.AlertRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AlertServiceImpl implements AlertService{

    private final AlertRepo alertRepo;

    @Override
    public Alert saveAlert(Alert alert) {
        return alertRepo.save(alert);
    }

    @Override
    public Optional<Alert> findById(Long id) {
        return alertRepo.findById(id);
    }

    @Override
    public void deleteAlert(Alert alert) {
        alertRepo.delete(alert);
    }
}
