package com.snkrphile.service.dtoConverter;

import com.snkrphile.service.dto.AlertDto;
import com.snkrphile.service.entities.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertConverter {

    public AlertDto alertToDto(Alert alert) {
        AlertDto dto = new AlertDto();
        dto.setId(alert.getId());
        dto.setTitle(alert.getTitle());
        dto.setType(alert.getType());
        dto.setFromUsername(alert.getFromUser());
        return dto;
    }
}
