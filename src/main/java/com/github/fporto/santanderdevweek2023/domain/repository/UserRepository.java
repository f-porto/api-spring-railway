package com.github.fporto.santanderdevweek2023.domain.repository;

import com.github.fporto.santanderdevweek2023.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
