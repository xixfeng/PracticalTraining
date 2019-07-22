package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Repository.TrainRepository;
import com.example.demo.Entity.Repository.TrainRouteRepository;
import com.example.demo.Entity.TrainEntity;
import com.example.demo.Entity.TrainRouteEntity;
import com.example.demo.Service.TrainService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServiceImp implements TrainService {
    private TrainRepository trainRepository;
    private TrainRouteRepository trainRouteRepository;
    @Autowired
    public void setTrainRepository(TrainRepository trainRepository,TrainRouteRepository trainRouteRepository){
        this.trainRepository=trainRepository;
        this.trainRouteRepository=trainRouteRepository;
    }
    @Override
    public ResponseEntity addTrain(TrainEntity trainEntity) {
        try{
            trainRepository.save(trainEntity);
            return new ResponseEntity(200,"增加列车成功",null);
        }catch (Exception e){
            System.out.println(e.toString());
            return new ResponseEntity(604,"增加列车错误",null);
        }
    }

    @Override
    public ResponseEntity deleteTrain(TrainEntity trainEntity) {
        try{
            trainRepository.deleteById(trainEntity.getTrainId());
            trainRouteRepository.deleteByTrainId(trainEntity.getTrainId());
            return new ResponseEntity(200,"删除列车成功",null);
        }catch (Exception e){
            return new ResponseEntity(605,"删除列车错误",null);
        }
    }

    @Override
    public ResponseEntity updateTrain(TrainEntity trainEntity) {
        try{
            Optional<TrainEntity> oldTrainEntity=trainRepository.findById(trainEntity.getTrainId());
            trainRepository.deleteById(trainEntity.getTrainId());
            oldTrainEntity.get().setType(trainEntity.getType());
            trainRepository.save(oldTrainEntity.get());
            return new ResponseEntity(200,"修改列车成功",null);
        }catch (Exception e){
            return new ResponseEntity(606,"修改列车错误",null);
        }
    }

    @Override
    public List<TrainEntity> queryTrain() {
        return trainRepository.findAll();
    }
}
