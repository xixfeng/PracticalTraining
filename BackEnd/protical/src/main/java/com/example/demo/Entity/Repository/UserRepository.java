package com.example.demo.Entity.Repository;

import com.example.demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByPhone(String phone);
    UserEntity findByUserName(String userName);
    @Query(value = "update user set balance = 1? where user_id=2?",nativeQuery =true)
    @Modifying
    @Transactional
    void updateUserBalance(Double balance,long userId);
}
