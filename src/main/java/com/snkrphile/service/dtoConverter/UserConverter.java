package com.snkrphile.service.dtoConverter;

import com.snkrphile.service.dto.UserDto;
import com.snkrphile.service.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverter {
    public UserDto userToDto(User user, Boolean partial) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setNumOfClosets(user.getClosets().size());
        userDto.setNumOfFollowers(user.getFriendsOf().size());
        userDto.setNumOfFollowing(user.getFriends().size());
        if(!partial) {
            userDto.setClosets(user.getClosets());
            userDto.setFriendRequests(user.getFriendRequests());
            List<String> friends = user.getFriends().stream().map(User::getUsername).toList();
            List<String> friendsOf = user.getFriendsOf().stream().map(User::getUsername).toList();
            userDto.setFriends(friends);
            userDto.setFriendsOf(friendsOf);
        }
        return userDto;
    }
}
