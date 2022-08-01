package com.snkrphile.service.api;

import com.snkrphile.service.domain.Closet;
import com.snkrphile.service.domain.User;
import com.snkrphile.service.services.ClosetService;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClosetController {
    private final ClosetService closetService;
    private final UserService userService;

    @PostMapping("closet/save")
    Closet saveCloset(@RequestBody Closet closet) {
        return closetService.saveCloset(closet);
    }

    @PutMapping("/{closetId}/closet/{username}")
    Closet assignUserToCloset(@PathVariable Long closetId, @PathVariable String username) {
        Closet closet = closetService.findById(closetId).get();
        User user = userService.getUser(username);
        closet.assignUser(user);
        return closetService.saveCloset(closet);
    }

    @GetMapping("/closet/{id}")
    Closet getClosetById(@PathVariable Long id) {
        Closet closet = closetService.findById(id).get();
        return closet;
    }

    @DeleteMapping("/closet/{id}/delete")
    String deleteCloset(@PathVariable Long id) {
        Closet closet = closetService.findById(id).get();
        closetService.deleteCloset(closet);
        return "Closet deleted";
    }
}
