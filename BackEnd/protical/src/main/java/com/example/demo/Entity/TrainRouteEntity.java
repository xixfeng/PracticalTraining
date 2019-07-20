package com.example.demo.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "train_route")
public class TrainRouteEntity {
    @Id
    private Long id;

    @Column(name = "train_id")
    private Long trainId;

    @Column(name = "origin_id")
    private Long originId;

    @Column(name = "destination_id")
    private Long destinationId;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "arrive_time")
    private Timestamp arriveTime;

    private Double fee;


    @Column(name = "remaining_tickets")
    private Long remainingTickets;


    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Long getRemainingTickets() {
        return remainingTickets;
    }

    public void setRemainingTickets(Long remainingTickets) {
        this.remainingTickets = remainingTickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

:

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
