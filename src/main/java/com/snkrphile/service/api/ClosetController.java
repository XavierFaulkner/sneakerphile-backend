package com.snkrphile.service.api;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.services.ClosetService;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClosetController {
    private final ClosetService closetService;
    private final UserService userService;

    @PostMapping("closet/save")
    Closet saveCloset(@RequestBody Closet closet, Authentication auth) {
        User principal = userService.getUser(auth.getName());
        closet.assignUser(principal);
        return closetService.saveCloset(closet);
    }

    @PutMapping("/{closetId}/closet/{username}")
    Closet assignUserToCloset(@PathVariable Long closetId, @PathVariable String username) {
        Closet closet = closetService.findById(closetId).get();
        User user = userService.getUser(username);
        closet.assignUser(user);
        return closetService.saveCloset(closet);
    }

    @GetMapping("/closet/get-closets-for/{username}")
    Collection<Closet> getClosestByUsername(@PathVariable String username) {
        return userService.getClosets(username);
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
