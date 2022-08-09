package com.snkrphile.service.api;

import com.snkrphile.service.dto.AlertDto;
import com.snkrphile.service.dtoConverter.AlertConverter;
import com.snkrphile.service.entities.Alert;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.response.ResponseHandler;
import com.snkrphile.service.response.forms.IdForm;
import com.snkrphile.service.services.AlertService;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlertController {

    private final UserService userService;
    private final AlertService alertService;
    private final AlertConverter alertConverter;

    @PostMapping("/alert/get-all")
    public ResponseEntity<Object> getAllAlerts(Authentication auth) {
        User principal = userService.getUser(auth.getName());
        List<AlertDto> alerts = principal.getAlerts().stream().map(alert -> alertConverter.alertToDto(alert, userService)).collect(Collectors.toList());
        return ResponseHandler.generateResponse("All alerts fetched", HttpStatus.OK, alerts);
    }

    @DeleteMapping("/alert/delete")
    public ResponseEntity<Object> deleteAlert(@RequestBody IdForm idForm) {
        Alert alert = alertService.findById(idForm.getId()).get();
        alertService.deleteAlert(alert);
        return ResponseHandler.generateResponse("Alert deleted", HttpStatus.OK, null);
    }
}
