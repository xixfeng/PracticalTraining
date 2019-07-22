package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.TrainOrderEntity;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Service.TrainOrderService;
import com.example.demo.Util.ResponseEntity;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/trainorder")
public class TrainOrderController {
    private TrainOrderService trainOrderService;
    @Autowired
    public TrainOrderController(TrainOrderService trainOrderService){
        this.trainOrderService=trainOrderService;
    }
    @RequestMapping(value="/judgeydaccount",method=POST)
    public ResponseEntity judgeYdAccount(@RequestBody String content, HttpSession session){
        Map map=(Map) JSON.parse(content);
        String phone=(String)map.get("phone");
        TrainRouteEntity trainRouteEntity=new TrainRouteEntity();
        trainRouteEntity.setTrainRouteEntity(map);
        return trainOrderService.judgeAccountEnough(trainRouteEntity,phone,"yd");
    }
    @RequestMapping(value="/judgeedaccount",method=POST)
    public ResponseEntity judgeEdAccount(@RequestBody String content, HttpSession session){
        String phone=(String) session.getAttribute("user");
        System.out.println("是不是第一次创建 session"+session.isNew()+" user: "+phone);
        Map map=(Map) JSON.parse(content);
        TrainRouteEntity trainRouteEntity=new TrainRouteEntity();
        trainRouteEntity.setTrainRouteEntity(map);
        return trainOrderService.judgeAccountEnough(trainRouteEntity,phone,"ed");
    }
    @RequestMapping(value="/buyticket",method = POST)
    public ResponseEntity buyTicket(@RequestBody String content){
        Map map=(Map)JSON.parse(content);
        TrainOrderEntity trainOrderEntity=new TrainOrderEntity(map);
        return trainOrderService.buyTicket(trainOrderEntity,"");
    }
    @RequestMapping(value = "/querytransation",method = POST)
    public ResponseEntity queryTransation(HttpSession session){
        String phone=(String)session.getAttribute("user");
        return trainOrderService.queryTransation(phone);
    }
}
