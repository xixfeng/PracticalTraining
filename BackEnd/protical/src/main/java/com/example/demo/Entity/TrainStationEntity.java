package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Map;

@Entity(name = "train_station")
public class TrainStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "train_station_id")
    private Long trainStationId;

    @Column(nullable = false)
    private String name;

    public Long getTrainStationId() {
        return trainStationId;
    }

    public void setTrainStationId(Long trainStationId) {
        this.trainStationId = trainStationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public TrainStationEntity(Map map){
        this.name=(String)map.get("name");
        this.trainStationId=Long.parseLong((String)map.get("trainStationId"));
    }
    public TrainStationEntity(){}
}
