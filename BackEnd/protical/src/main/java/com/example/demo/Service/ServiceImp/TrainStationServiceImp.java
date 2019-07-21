package com.example.demo.Service.ServiceImp;

import com.example.demo.Entity.Repository.TrainRouteRepository;
import com.example.demo.Entity.Repository.TrainStationRepository;
import com.example.demo.Entity.TrainStationEntity;
import com.example.demo.Service.TrainStationService;
import com.example.demo.Util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainStationServiceImp implements TrainStationService {
    private TrainStationRepository trainStationRepository;
    private TrainRouteRepository trainRouteRepository;
    @Autowired
    public TrainStationServiceImp(TrainStationRepository trainStationRepository,TrainRouteRepository trainRouteRepository){
        this.trainRouteRepository=trainRouteRepository;
        this.trainStationRepository=trainStationRepository;
    }
    @Override
    public ResponseEntity addTrainStation(TrainStationEntity trainStationEntity) {
        try{
            trainStationRepository.save(trainStationEntity);
            return new ResponseEntity(200,"增加站点成功",null);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(608,"增加站点错误",null);
        }
    }

    @Override
    public ResponseEntity deleteTrainStation(TrainStationEntity trainStationEntity) {
        try{
            trainStationRepository.deleteById(trainStationEntity.getTrainStationId());
            return new ResponseEntity(200,"删除站点成功",null);
        }
        catch (Exception e){
            return new ResponseEntity(609,"删除站点失败",null);
        }
    }

    @Override
    public ResponseEntity updateTrainStation(TrainStationEntity trainStationEntity) {
        try{
            trainStationRepository.deleteById(trainStationEntity.getTrainStationId());
            trainStationRepository.save(trainStationEntity);
            return new ResponseEntity(200,"更新站点成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(610,"更新站点失败",null);
        }
    }

    @Override
    public List<TrainStationEntity> queryTrainStation() {
        return trainStationRepository.findAll();
    }
}
