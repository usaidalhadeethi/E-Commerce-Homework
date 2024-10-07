package com.spring1.trendyol_odevi.service;

import com.spring1.trendyol_odevi.entity.User;
import com.spring1.trendyol_odevi.repository.UserRepository;
import com.spring1.trendyol_odevi.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO save(UserDTO dto) {
        User user = toEntity(dto);
        userRepository.save(user);
        return toDto(user);
    }

    public UserDTO findById(String id) {
        User user = userRepository.getUserById(Integer.parseInt(id)).orElse(null);
        return toDto(user);
    }

    private User toEntity(UserDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        user.setUserId(dto.getUserId());
        user.setBaskets(dto.getBaskets());
        return user;
    }

    private UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setPassword(user.password);
        dto.setBaskets(user.getBaskets());
        return dto;
    }
}
