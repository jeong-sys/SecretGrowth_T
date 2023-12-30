package com.swproject.swproject.repo;

import com.swproject.swproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserId(String userId);
    // Optional<User> findByUserIdByName(String name, LocalDate dateOfBirth);

}
