package com.footballmanager.repositories;

import com.footballmanager.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Long>{
    Optional<Manager> findByUsername(String username);
    boolean existsByUsername(String username);
}