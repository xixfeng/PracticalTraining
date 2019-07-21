package com.example.demo.Entity;
import javax.persistence.*;
import java.util.Map;

@Entity(name = "train")
public class TrainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String trainId;

    private String type;


    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public TrainEntity(Map map){
        this.trainId=(String)map.get("trainId");
        this.type=(String)map.get("type");
    }

}