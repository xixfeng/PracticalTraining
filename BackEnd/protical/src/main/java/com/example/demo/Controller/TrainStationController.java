package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.TrainStationEntity;
import com.example.demo.Service.ServiceImp.TrainStationServiceImp;
import com.example.demo.Service.TrainStationService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trainstation")
public class TrainStationController {
    private TrainStationService trainStationService;
    @Autowired
    public TrainStationController(TrainStationService trainStationService){
        this.trainStationService=trainStationService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addStation(@RequestBody String content){
        Map map=(Map) JSON.parse(content);
        TrainStationEntity trainStationEntity=new TrainStationEntity(map);
        return trainStationService.addTrainStation(trainStationEntity);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity deleteStation(@RequestBody String content){
        Map map=(Map)JSON.parse(content);
        TrainStationEntity trainStationEntity=new TrainStationEntity(map);
        return trainStationService.deleteTrainStation(trainStationEntity);
    }
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public List<TrainStationEntity> queryStation(@RequestBody String content){
        return trainStationService.queryTrainStation();
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity updateStation(@RequestBody String content){
        Map map=(Map)JSON.parse(content);
        TrainStationEntity trainStationEntity=new TrainStationEntity(map);
        return trainStationService.updateTrainStation(trainStationEntity);
    }

}
