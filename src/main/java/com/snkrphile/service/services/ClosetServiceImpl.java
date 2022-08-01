package com.snkrphile.service.services;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.repo.ClosetRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class ClosetServiceImpl implements ClosetService {

    private final ClosetRepo closetRepo;

    @Override
    public Closet saveCloset(Closet closet) {
        log.info("Saving new closet {} to the database", closet.getName());
        return closetRepo.save(closet);
    }

    @Override
    public Optional<Closet> findById(Long id) {
        return closetRepo.findById(id);
    }

    @Override
    public void deleteCloset(Closet closet) {
        closetRepo.delete(closet);
    }
}
