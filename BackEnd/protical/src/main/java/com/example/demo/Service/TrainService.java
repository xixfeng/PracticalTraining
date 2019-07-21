package com.example.demo.Service;

import com.example.demo.Entity.TrainEntity;
import com.example.demo.Util.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainService {
    ResponseEntity addTrain(TrainEntity trainEntity);
    ResponseEntity deleteTrain(TrainEntity trainEntity);
    ResponseEntity updateTrain(TrainEntity trainEntity);
    List<TrainEntity> queryTrain();
}
