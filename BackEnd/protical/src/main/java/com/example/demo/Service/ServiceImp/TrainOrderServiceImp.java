package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Repository.TrainOrderRepository;
import com.example.demo.Entity.Repository.TrainRouteRepository;
import com.example.demo.Entity.Repository.UserRepository;
import com.example.demo.Entity.TrainOrderEntity;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.TrainOrderService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainOrderServiceImp implements TrainOrderService {
    private TrainOrderRepository trainOrderRepository;
    private UserRepository userRepository;
    private TrainRouteRepository trainRouteRepository;
    @Autowired
    public TrainOrderServiceImp(TrainRouteRepository trainRouteRepository,TrainOrderRepository trainOrderRepository,UserRepository userRepository){
        this.trainOrderRepository=trainOrderRepository;
        this.userRepository=userRepository;
        this.trainRouteRepository=trainRouteRepository;
    }
    @Override
    public ResponseEntity judgeAccountEnough(TrainRouteEntity trainRouteEntity, String phoneNumber,String type) {
        try{
            TrainOrderEntity trainOrderEntity=new TrainOrderEntity();
            trainOrderEntity.setDestination(trainRouteEntity.getDestination());
            trainOrderEntity.setOrgin(trainRouteEntity.getOrigin());
            long userId=userRepository.findByPhone(phoneNumber).getUserId();
            trainOrderEntity.setUserId(userId);
            trainOrderEntity.setTrainId(trainRouteEntity.getTrainId());
            trainOrderEntity.setType(trainRouteEntity.getTrainId().charAt(0)+"");
            Double account=userRepository.findByPhone(phoneNumber).getBalance();
            if(type.equals("yd")){
                Double ydPrice=trainRouteEntity.getYdPrice();
                System.out.println("yd="+ydPrice+" account="+account);
                if(account!=null&&account>=ydPrice){
                    trainOrderEntity.setFee(trainRouteEntity.getYdPrice());
                    trainOrderEntity.setDiscount(1.0);
                    trainOrderEntity.setSeat("一等座");
                    return new ResponseEntity(200,"余额充足",trainOrderEntity);
                }else{
                    return new ResponseEntity(701,"余额不足",null);
                }
            }
            else{
                Double edPrice=trainRouteEntity.getEdPrice();
                if(account>=edPrice){
                    trainOrderEntity.setFee(trainRouteEntity.getEdPrice());
                    trainOrderEntity.setDiscount(1.0);
                    trainOrderEntity.setSeat("二等座");
                    return new ResponseEntity(200,"余额充足",trainOrderEntity);
                }else{
                    return new ResponseEntity(701,"余额不足",null);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(700,"发生意外",null);
        }
    }
    @Override
    public ResponseEntity buyTicket(TrainOrderEntity trainOrderEntity, String phoneNumber) {
        try{
            //余额要减少。
            UserEntity userEntity=userRepository.findById(trainOrderEntity.getUserId()).get();
            Double balance=userRepository.findById(trainOrderEntity.getUserId()).get().getBalance();
            Double fee=trainOrderEntity.getFee()*trainOrderEntity.getDiscount();
            System.out.println(balance);
            balance=balance-fee;
            System.out.println(balance);
            userEntity.setBalance(balance);
            userRepository.save(userEntity);
            //userRepository.updateUserBalance(balance,trainOrderEntity.getUserId());
            //System.out.println(trainOrderEntity.toString());
            trainOrderRepository.save(trainOrderEntity);
            return new ResponseEntity(200,"success buy",null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(702,"购票失败",null);
        }
    }

    @Override
    public ResponseEntity queryTransation(String phoneNumber) {
        try {
            UserEntity userEntity=userRepository.findByPhone(phoneNumber);
            System.out.println(phoneNumber+":"+userEntity.getUserId());
            List<TrainOrderEntity> trainOrderEntityList = trainOrderRepository.findOrderById(userEntity.getUserId());
            System.out.println(trainOrderEntityList.size());
            return new ResponseEntity(200,"succuss query",trainOrderEntityList);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(703,"error query",null);
        }
    }
}
