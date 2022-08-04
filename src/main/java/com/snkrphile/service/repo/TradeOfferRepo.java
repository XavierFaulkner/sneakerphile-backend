package com.snkrphile.service.repo;

import com.snkrphile.service.entities.TradeOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TradeOfferRepo extends JpaRepository<TradeOffer, Long> {
    Optional<TradeOffer> findById(Long aLong);
}
