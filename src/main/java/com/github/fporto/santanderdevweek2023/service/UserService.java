package com.github.fporto.santanderdevweek2023.service;

import com.github.fporto.santanderdevweek2023.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User user);
}
