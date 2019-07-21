package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Repository.UserRepository;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.AdminUserService;
import com.example.demo.Util.ResponseEntity;
import com.example.demo.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminUserServiceImp implements AdminUserService {
    private UserRepository userRepository;
    @Autowired
    void init(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return ResponseUtil.success();
    }

    @Override
    public ResponseEntity deleteUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
        return ResponseUtil.success();
    }

    @Override
    public ResponseEntity updateUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return ResponseUtil.success();
    }

    @Override
    public List<UserEntity> queryUser() {
        return userRepository.findAll();
    }
}
