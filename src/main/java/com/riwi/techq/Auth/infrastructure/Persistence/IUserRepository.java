package com.riwi.techq.Auth.infrastructure.Persistence;


import com.riwi.techq.Auth.Domain.Role;
import com.riwi.techq.Auth.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    List<User> findByRoleAndActive(Role role, boolean active);
    Optional<User> findById(int id);
}
