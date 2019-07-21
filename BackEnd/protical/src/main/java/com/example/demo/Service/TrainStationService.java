package com.example.demo.Service;

import com.example.demo.Entity.TrainEntity;
import com.example.demo.Entity.TrainStationEntity;
import com.example.demo.Util.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TrainStationService {
    ResponseEntity addTrainStation(TrainStationEntity trainStationEntity);
    ResponseEntity deleteTrainStation(TrainStationEntity trainStationEntity);
    ResponseEntity updateTrainStation(TrainStationEntity trainStationEntity);
    List<TrainStationEntity> queryTrainStation();
}
