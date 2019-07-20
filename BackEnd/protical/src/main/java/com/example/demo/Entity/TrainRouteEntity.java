package com.example.demo.Entity;
import javax.persistence.*;
import java.sql.Time;

@Entity(name = "train_route")
public class TrainRouteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "train_id")
    private String trainId;

    private String origin;

    private String destination;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "arrive_time")
    private Time arriveTime;

    private Long ydNum;

    private Double ydPrice;

    private Long edNum;

    private Double edPrice;



    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Double getEdPrice() {
        return edPrice;
    }

    public void setEdPrice(Double edPrice) {
        this.edPrice = edPrice;
    }

    public Long getYdNum() {
        return ydNum;
    }

    public void setYdNum(Long ydNum) {
        this.ydNum = ydNum;
    }

    public Double getYdPrice() {
        return ydPrice;
    }

    public void setYdPrice(Double ydPrice) {
        this.ydPrice = ydPrice;
    }

    public Long getEdNum() {
        return edNum;
    }

    public void setEdNum(Long edNum) {
        this.edNum = edNum;
    }
}
