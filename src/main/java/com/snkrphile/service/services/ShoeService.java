package com.snkrphile.service.services;

import com.snkrphile.service.domain.Shoe;

import java.util.Optional;

public interface ShoeService {
    Shoe saveShoe(Shoe shoe);

    Optional<Shoe> findById(Long id);

    void deleteShoe(Shoe shoe);
}
