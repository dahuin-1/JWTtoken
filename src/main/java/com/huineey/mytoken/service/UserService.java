package com.huineey.mytoken.service;

import com.huineey.mytoken.domain.User;
import com.huineey.mytoken.domain.UserDTO;
import com.huineey.mytoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Integer join(UserDTO user) {
        Integer userId = userRepository.save(
                User.builder()
                        .email(user.getEmail())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(Collections.singletonList("ROLE_USER"))
                        .build())
                .getId();
        return userId;
    }
}