package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Entity.TrainEntity;
import com.example.demo.Service.TrainService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/train")
public class TrainController {
    private TrainService trainService;
    @Autowired
    public TrainController(TrainService trainService){
        this.trainService=trainService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addTrain(@RequestBody String content){
        Map map= (Map) JSON.parse(content);
        TrainEntity trainEntity=new TrainEntity(map);
        return  trainService.addTrain(trainEntity);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity deleteTrain(@RequestBody String content){
        Map map=(Map)JSON.parse(content);
        TrainEntity trainEntity=new TrainEntity(map);
        return trainService.deleteTrain(trainEntity);
    }
    @RequestMapping(value="/query")
    public List<TrainEntity> queryTrain(){
        return trainService.queryTrain();
    }
    @RequestMapping(value="/update")
    public ResponseEntity updateTrain(@RequestBody String content){
        Map map=(Map)JSON.parse(content);
        TrainEntity trainEntity=new TrainEntity(map);
        return trainService.updateTrain(trainEntity);
    }
}
