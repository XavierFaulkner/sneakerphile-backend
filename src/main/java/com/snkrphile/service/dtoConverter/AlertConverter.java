package com.snkrphile.service.dtoConverter;

import com.snkrphile.service.dto.AlertDto;
import com.snkrphile.service.entities.Alert;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class AlertConverter {

    UserService userService;

    public AlertDto alertToDto(Alert alert, UserService userService) {
        AlertDto dto = new AlertDto();
        dto.setId(alert.getId());
        dto.setTitle(alert.getTitle());
        dto.setType(alert.getType());
        switch(alert.getType()) {
            case "FRIEND-REQUEST":
                User fromUser = userService.getUser(alert.getFromUser());
                dto.setRequestId(alert.getRequestId());
                //get user since
                //get total num of shoes
                dto.setNumOfCollections(fromUser.getClosets().size());
                dto.setNumOfFollowers(fromUser.getFriendsOf().size());
                dto.setNumOfFollowing(fromUser.getFriends().size());
        }
        return dto;
    }
}
