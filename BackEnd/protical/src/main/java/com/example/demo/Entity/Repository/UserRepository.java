package com.example.demo.Entity.Repository;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByPhone(String phone);
    UserEntity findByUserName(String userName);
}
