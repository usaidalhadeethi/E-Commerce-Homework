package com.spring1.trendyol_odevi.user.api;


public interface UserService {
    public UserDTO save(UserDTO dto);
    public UserDTO findById(String id);
    public UserDTO findByUserName(String userName);
}