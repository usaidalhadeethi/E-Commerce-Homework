package com.spring1.trendyol_odevi.basket.impl;

import com.spring1.trendyol_odevi.user.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, String> {
    public Basket findByUser (User user);
    public Basket findByUserAndStatus (User user, int status);

}

