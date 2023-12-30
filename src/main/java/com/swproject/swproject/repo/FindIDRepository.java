package com.swproject.swproject.repo;

import com.swproject.swproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FindIDRepository extends JpaRepository<User, Long>{

    Optional<User> findByNameAndDateOfBirth(String name, LocalDate dateOfBirth);

}
