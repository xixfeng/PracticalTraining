package com.example.demo.Controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.Service.UserService;
import com.example.demo.Util.ResponseEntity;
import com.example.demo.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public void setService(UserService userService){
        this.userService = userService;
    }


    @RequestMapping("/login")
    public ResponseEntity login(@RequestBody String json,HttpSession session){
        Map map = (Map) JSON.parse(json);
        String phone = map.get("phone").toString();
        String key = map.get("key").toString();
        ResponseEntity responseEntity = userService.login(phone,key);
        if(responseEntity != null){
            session.setAttribute("user",phone);
            return responseEntity;
        }
        else return ResponseUtil.error(400,"用户名或密码错误");
    }

    @RequestMapping("/signOut")
    public ResponseEntity signOut(HttpSession session){
        session.removeAttribute("user");
        return ResponseUtil.success();
    }

    @RequestMapping("/register")
    public ResponseEntity register(@RequestBody String json){
        Map map = (Map)JSON.parse(json);
        String user = map.get("user").toString();
        String key = map.get("key").toString();
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        return userService.register(user,key,phone,code);
    }

    @RequestMapping("/retrievePassword")
    public ResponseEntity retrievePassword(@RequestBody String json){
        Map map = (Map)JSON.parse(json);
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        String key = map.get("key").toString();
        return userService.retrievePassword(phone,key,code);
    }

    @RequestMapping("/getCode")
    public Object getCode(@RequestBody String json) {
        Map map = (Map) JSON.parse(json);
        String phone = map.get("phone").toString();
        userService.getCode(phone);
        return ResponseUtil.success();
    }
}
