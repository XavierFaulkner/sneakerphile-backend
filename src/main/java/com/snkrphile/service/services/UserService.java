package com.snkrphile.service.services;

import com.snkrphile.service.domain.Closet;
import com.snkrphile.service.domain.User;
import com.snkrphile.service.domain.Role;

import java.util.Collection;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    Collection<Closet> getClosets(String username);
}
