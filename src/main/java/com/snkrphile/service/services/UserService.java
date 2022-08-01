package com.snkrphile.service.services;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.entities.Role;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    void addFriendToUser(String friendUsername, String username);
    User getUser(String username);
    List<User> getUsers();
    Collection<Closet> getClosets(String username);
}
