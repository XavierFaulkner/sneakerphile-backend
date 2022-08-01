package com.snkrphile.service.services;

import com.snkrphile.service.domain.Closet;

import java.util.List;
import java.util.Optional;

public interface ClosetService {
    Closet saveCloset(Closet closet);
    Optional<Closet> findById(Long id);
    void deleteCloset(Closet closet);
}
