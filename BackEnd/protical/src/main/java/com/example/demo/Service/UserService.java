package com.example.demo.Service;
import com.example.demo.Util.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public interface UserService {
    ResponseEntity login(String phone, String key);
    ResponseEntity register(String user, String key, String phone,String code);
    ResponseEntity retrievePassword(String phone,String key,String code);
    String getCode(String phone);
    Boolean isAdmin(HttpSession session);
    Boolean isUserExist(String phone);
}
