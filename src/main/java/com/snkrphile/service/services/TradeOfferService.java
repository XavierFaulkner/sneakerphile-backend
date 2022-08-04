package com.snkrphile.service.services;

import com.snkrphile.service.entities.TradeOffer;

import java.util.Optional;

public interface TradeOfferService {
    TradeOffer saveTradeOffer(TradeOffer tradeOffer);
    Optional<TradeOffer> findById(Long id);
    void deleteOffer(TradeOffer offer);
}
