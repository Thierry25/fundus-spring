package com.thierry.fundus.repositories;

import com.thierry.fundus.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameContainingIgnoreCase (String username);
}
