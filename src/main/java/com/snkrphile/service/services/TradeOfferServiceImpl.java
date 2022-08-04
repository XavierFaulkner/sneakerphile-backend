package com.snkrphile.service.services;

import com.snkrphile.service.entities.TradeOffer;
import com.snkrphile.service.repo.TradeOfferRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class TradeOfferServiceImpl implements TradeOfferService{

    private final TradeOfferRepo tradeOfferRepo;

    @Override
    public TradeOffer saveTradeOffer(TradeOffer tradeOffer) {
        return tradeOfferRepo.save(tradeOffer);
    }

    @Override
    public Optional<TradeOffer> findById(Long id) {
        return tradeOfferRepo.findById(id);
    }

    @Override
    public void deleteOffer(TradeOffer offer) {
        tradeOfferRepo.delete(offer);
    }
}
