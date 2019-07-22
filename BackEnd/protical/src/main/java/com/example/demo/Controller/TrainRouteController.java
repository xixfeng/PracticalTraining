package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.TrainRouteService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainroute")
public class TrainRouteController {
     TrainRouteService trainRouteService;
     @Autowired
     public void setTrainRouteService(TrainRouteService trainRouteService){
         this.trainRouteService=trainRouteService;
     }
    @RequestMapping(value = "/searchticket",method = RequestMethod.POST)
    public List<TrainRouteEntity> queryTrain(@RequestBody String json){
        System.out.println(json);
        Map requestParam= (Map) JSON.parse(json);
        String startCity=(String)requestParam.get("startcity");
        String arrivalCity=(String) requestParam.get("arrivalcity");
        String arrivalDay=(String)requestParam.get("arrivalday");
        return trainRouteService.queryTrainByOrignAndArrival(startCity,arrivalCity);
    }
    //管理员增加线路
    @RequestMapping(value = "/addticket",method=RequestMethod.POST)
    public ResponseEntity addTicket(@RequestBody String content){
        Map newTrainRoute=(Map)JSON.parse(content);
        TrainRouteEntity trainRouteEntity = JSON.parseObject(content,TrainRouteEntity.class);
        return trainRouteService.insertNewRoute(trainRouteEntity);
    }
    //管理员删除线路,要考虑连锁反应
    @RequestMapping(value="/deleteticket",method=RequestMethod.POST)
    public ResponseEntity deleteTicket(@RequestBody String content){
         Map toDeleteTrainRoute=(Map)JSON.parse(content);
         Long id = Long.parseLong(toDeleteTrainRoute.get("id").toString());
         return trainRouteService.deleteRouteById(id);
    }
    //管理员更改线路，已经下单的不管。
    @RequestMapping(value="/updateticket",method = RequestMethod.POST)
    public ResponseEntity updateTicket(@RequestBody String content){
         Map newTrainRoute=(Map)JSON.parse(content);
         TrainRouteEntity updateTrainRouteEntity=new TrainRouteEntity();
         updateTrainRouteEntity.setTrainRouteEntity(newTrainRoute);
         return trainRouteService.updateRoute(updateTrainRouteEntity.getId(),updateTrainRouteEntity);
    }
}
