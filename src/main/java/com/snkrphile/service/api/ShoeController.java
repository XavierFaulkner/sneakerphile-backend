package com.snkrphile.service.api;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.entities.Shoe;
import com.snkrphile.service.services.ClosetService;
import com.snkrphile.service.services.ShoeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShoeController {
    private final ShoeService shoeService;
    private final ClosetService closetService;

    @PostMapping("/shoe/save")
    Shoe saveShoe(@RequestBody Shoe shoe) {
        return shoeService.saveShoe(shoe);
    }

    @PutMapping("/{shoeId}/shoe/{closetId}")
    Shoe assignClosetToShoe(@PathVariable Long shoeId, @PathVariable Long closetId) {
        Shoe shoe = shoeService.findById(shoeId).get();
        Closet closet = closetService.findById(closetId).get();
        shoe.assignCloset(closet);
        return shoeService.saveShoe(shoe);
    }

    @GetMapping("/shoe/{id}")
    Shoe getShoeById(@PathVariable Long id) {
        return shoeService.findById(id).get();
    }

    @PutMapping("/shoe/{id}/update")
    Shoe updateShoe(@PathVariable Long id, @RequestBody Shoe shoe) {
        Shoe s = shoeService.findById(id).get();
        if(shoe.getName() != null) {
            s.setName(shoe.getName());
        }
        return shoeService.saveShoe(s);
    }

    @DeleteMapping("shoe/{id}/delete")
    String deleteShoe(@PathVariable Long id) {
        Shoe shoe = shoeService.findById(id).get();
        shoeService.deleteShoe(shoe);
        return "Shoe deleted";
    }

}
