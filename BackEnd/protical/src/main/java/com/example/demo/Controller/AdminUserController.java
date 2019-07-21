package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.AdminUserService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adminUser")
public class AdminUserController {
    private AdminUserService adminUserService;

    @Autowired
    void init(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addTrain(@RequestBody String content){
        UserEntity userEntity = JSON.parseObject(content,UserEntity.class);
        return  adminUserService.addUser(userEntity);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity deleteTrain(@RequestBody String content){
        UserEntity userEntity = JSON.parseObject(content,UserEntity.class);
        return adminUserService.deleteUser(userEntity);
    }
    @RequestMapping(value="/query")
    public List<UserEntity> queryTrain(){
        return adminUserService.queryUser();
    }
    @RequestMapping(value="/update")
    public ResponseEntity updateTrain(@RequestBody String content){
        UserEntity userEntity = JSON.parseObject(content,UserEntity.class);
        return adminUserService.updateUser(userEntity);
    }
}
