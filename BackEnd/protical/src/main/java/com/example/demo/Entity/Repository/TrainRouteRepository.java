package com.example.demo.Entity.Repository;

import com.example.demo.Entity.TrainRouteEntity;
import org.apache.ibatis.annotations.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainRouteRepository extends JpaRepository<TrainRouteEntity,Long> {
     @Query(value = "select * from train_route where origin=?1 and destination=?2",nativeQuery = true)
     List<TrainRouteEntity> queryByOriginAndDestination(String origin,String destination);
     int deleteById(long id);
     @Query(value="delete from train_route where trainId=?1",nativeQuery = true)
     @Modifying
     void deleteByTrainId(String trainId);
}
