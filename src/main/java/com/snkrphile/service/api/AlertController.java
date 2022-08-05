package com.snkrphile.service.api;

import com.snkrphile.service.entities.User;
import com.snkrphile.service.response.ResponseHandler;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlertController {

    private final UserService userService;

    @PostMapping("/alert/get-all")
    public ResponseEntity<Object> getAllAlerts(Authentication auth) {
        User principal = userService.getUser(auth.getName());

        return ResponseHandler.generateResponse("All alerts fetched", HttpStatus.OK, null);
    }
}
