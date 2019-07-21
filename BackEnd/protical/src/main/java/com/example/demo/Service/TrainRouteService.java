package com.example.demo.Service;

import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Util.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public interface TrainRouteService {
    List<TrainRouteEntity> queryTrainByOrignAndArrival(String origin,String destination);
    ResponseEntity insertNewRoute(TrainRouteEntity trainRouteEntity);
    ResponseEntity updateRoute(long id,TrainRouteEntity trainRouteEntity);
    ResponseEntity deleteRouteById(long id);
}
