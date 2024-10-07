package com.spring1.trendyol_odevi.controller;

import com.spring1.trendyol_odevi.controller.request.UserRequest;
import com.spring1.trendyol_odevi.controller.response.UserResponse;
import com.spring1.trendyol_odevi.service.dto.UserDTO;
import com.spring1.trendyol_odevi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest) {
        UserDTO savedUser = userService.save(toDto(userRequest));
        return toResponse(savedUser);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable("id") String id) {
        UserDTO userDto = userService.findById(id);
        return toResponse(userDto);
    }

    private UserDTO toDto(UserRequest request) {
        UserDTO dto = new UserDTO();
        dto.setUserName(request.getUserName());
        dto.setPassword(request.getPassword());
        dto.setUserId(request.getUserId());
        dto.setBaskets(request.getBaskets());
        return dto;
    }

    private UserResponse toResponse(UserDTO dto) {
        UserResponse response = new UserResponse();
        response.setUserId(dto.getUserId());
        response.setUserName(dto.getUserName());
        response.setBaskets(dto.getBaskets());
        response.setPassword(dto.getPassword());
        return response;
    }
}
