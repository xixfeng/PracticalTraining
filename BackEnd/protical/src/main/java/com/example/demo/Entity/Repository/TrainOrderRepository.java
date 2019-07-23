package com.example.demo.Entity.Repository;

import com.example.demo.Entity.TrainOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainOrderRepository extends JpaRepository<TrainOrderEntity,Long> {
    @Query(value = "select * from train_order where user_id=?",nativeQuery = true)
    List<TrainOrderEntity> findOrderById(long id);
}
