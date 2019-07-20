package com.example.demo.Service.ServiceImp;
import com.example.demo.Entity.Repository.UserRepository;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.UserService;
import com.example.demo.Util.RandomGenerator;
import com.example.demo.Util.ResponseEntity;
import com.example.demo.Util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    private RedisTemplate redisTemplate;
    private VerificationCode verificationCode;


    @Autowired
    public void setRepository(UserRepository userRepository, RedisTemplate redisTemplate,
                              VerificationCode verificationCode){
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
        this.verificationCode = verificationCode;
    }

    @Override
    public ResponseEntity login(String phone, String key) {
        UserEntity userEntity = userRepository.findByPhone(phone);
        if(userEntity == null)return null;
        if(userEntity.getPassword().equals(key)){
            userEntity.setPassword(null);
            return new ResponseEntity(200,"",userEntity);
        }
        else return null;
    }

    @Override
    public ResponseEntity register(String user, String key, String phone, String code) {
        if(userRepository.findByPhone(phone)!=null)return new ResponseEntity(401,"手机号已被使用",null);
        String ecode = redisTemplate.opsForValue().get(phone).toString();
        if(!ecode.equals(code))return new ResponseEntity(400,"验证码错误",null);
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user);
        userEntity.setPassword(key);
        userEntity.setPhone(phone);
        userEntity.setRole("customer");
        userRepository.save(userEntity);
        return new ResponseEntity(200,null,null);
    }

    @Override
    public ResponseEntity retrievePassword(String phone, String key, String code) {
        UserEntity userEntity = userRepository.findByPhone(phone);
        if(userEntity==null)return new ResponseEntity(401,"用户不存在",null);
        String ecode = redisTemplate.opsForValue().get(userEntity.getPhone()).toString();
        if(!ecode.equals(code))return new ResponseEntity(400,"验证码错误",null);
        userEntity.setPassword(key);
        userRepository.save(userEntity);
        return new ResponseEntity(200,"修改成功",null);
    }

    @Override
    public String getCode(String phone) {
        String code = RandomGenerator.generateCode();
        redisTemplate.opsForValue().set(phone,code,604800, TimeUnit.SECONDS);
        verificationCode.getCode(phone, code);
        return "发送成功";
    }

    @Override
    public Boolean isAdmin(HttpSession session) {
        String user = session.getAttribute("user").toString();
        if(user==null)return false;
        UserEntity userEntity = userRepository.findByPhone(user);
        return userEntity.getRole().equals("admin");
    }

    @Override
    public Boolean isUserExist(String phone) {
        UserEntity userEntity = userRepository.findByPhone(phone);
        return userEntity != null;
    }
}
