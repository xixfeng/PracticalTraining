package com.example.demo.Service;

import com.example.demo.Entity.Repository.TrainRouteRepository;
import com.example.demo.Entity.TrainOrderEntity;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Util.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface TrainOrderService {
    //买票时，前端根据查询出来的数据先判断是否有剩余，然后进行买票
    ResponseEntity judgeAccountEnough(TrainRouteEntity trainRouteEntity, String phoneNumber,String type);
    //买票接口
    ResponseEntity buyTicket(TrainOrderEntity trainOrderEntity,String phoneNumber);
    //查询账单
    ResponseEntity queryTransation(String phoneNumber);
}
