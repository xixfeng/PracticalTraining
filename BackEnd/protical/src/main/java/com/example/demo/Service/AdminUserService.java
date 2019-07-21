package com.example.demo.Service;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Util.ResponseEntity;

import java.util.List;

public interface AdminUserService {
    ResponseEntity addUser(UserEntity userEntity);
    ResponseEntity deleteUser(UserEntity userEntity);
    ResponseEntity updateUser(UserEntity userEntity);
    List<UserEntity> queryUser();
}
