package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Repository.TrainRouteRepository;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Service.TrainRouteService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainRouteServiceImp implements TrainRouteService {
    @Autowired
    private TrainRouteRepository trainRouteRepository;
    @Autowired
    public TrainRouteServiceImp(TrainRouteRepository trainRouteRepository){
        this.trainRouteRepository=trainRouteRepository;
    }
    @Override
    public List<TrainRouteEntity> queryTrainByOrignAndArrival(String origin, String destination) {
        return trainRouteRepository.queryByOriginAndDestination(origin,destination);
    }

    @Override
    public ResponseEntity insertNewRoute(TrainRouteEntity trainRouteEntity) {
        try{
            trainRouteRepository.saveAndFlush(trainRouteEntity);
            ResponseEntity responseEntity=new ResponseEntity(200,null,null);
            return responseEntity;
        }catch(Exception e){
            return new ResponseEntity(401,"增加线路错误",null);
        }
    }

    @Override
    public ResponseEntity updateRoute(long id, TrainRouteEntity trainRouteEntity) {
        try{
            Optional<TrainRouteEntity> oldEntity=trainRouteRepository.findById(id);
            oldEntity.get().setByEntity(trainRouteEntity);
            trainRouteRepository.save(oldEntity.get());
            return new ResponseEntity(200,"修改成功",null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(601,"修改有误",null);
        }

    }

    @Override
    public ResponseEntity deleteRouteById(long id) {
        try{
            trainRouteRepository.deleteById(id);
            return new ResponseEntity(200,"成功删除",null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(602,"删除出错",null);
        }
    }
}
