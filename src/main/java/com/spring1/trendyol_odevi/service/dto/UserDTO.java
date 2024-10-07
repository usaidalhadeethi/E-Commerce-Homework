package com.spring1.trendyol_odevi.service.dto;

import com.spring1.trendyol_odevi.entity.Basket;
import java.util.List;

public class UserDTO {
    public String userId;
    public String userName;
    public String password;
    public List<Basket> baskets;

    public UserDTO() {
    }

    public UserDTO(String userId, String userName, String password, List<Basket> baskets) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.baskets = baskets;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }
}
