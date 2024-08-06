package com.github.fporto.santanderdevweek2023.service;

import com.github.fporto.santanderdevweek2023.domain.model.User;
import com.github.fporto.santanderdevweek2023.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            var msg = String.format("There is no user with id `%d`", id);
            return new NoSuchElementException(msg);
        });
    }

    @Override
    public User create(User user) {
        var accountNumber = user.getAccount().getNumber();
        if (accountNumber != null && userRepository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Account number already exists");
        }
        return userRepository.save(user);
    }
}
