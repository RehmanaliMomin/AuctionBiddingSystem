package com.cars24.auction.repository;

import com.cars24.auction.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    public User getByUserId(Long userId);
}
