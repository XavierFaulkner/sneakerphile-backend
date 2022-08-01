package com.snkrphile.service.services;

import com.snkrphile.service.domain.Shoe;
import com.snkrphile.service.repo.ShoeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class ShoeServiceImpl implements ShoeService{
    private final ShoeRepo shoeRepo;
    @Override
    public Shoe saveShoe(Shoe shoe) {
        return shoeRepo.save(shoe);
    }

    @Override
    public Optional<Shoe> findById(Long id) {
        return shoeRepo.findById(id);
    }

    @Override
    public void deleteShoe(Shoe shoe) {
        shoeRepo.delete(shoe);
    }
}
