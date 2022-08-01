package com.snkrphile.service.repo;

import com.snkrphile.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
