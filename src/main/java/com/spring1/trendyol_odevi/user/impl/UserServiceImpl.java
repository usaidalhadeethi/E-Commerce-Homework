package com.spring1.trendyol_odevi.user.impl;

import com.spring1.trendyol_odevi.user.api.UserDTO;
import com.spring1.trendyol_odevi.user.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO save(UserDTO dto) {
        User user = toEntity(dto);
        userRepository.save(user);
        return toDto(user);
    }

    @Override
    public UserDTO findById(String id) {
        User user = userRepository.findById(id).orElse(null);

        return toDto(user);
    }

    @Override
    public UserDTO findByUserName(String userName) {
        // Find user by username from the repository
        User user = userRepository.findByUserName(userName);

        return toDto(user);
    }

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        return user;
    }

    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        return dto;
    }
}

