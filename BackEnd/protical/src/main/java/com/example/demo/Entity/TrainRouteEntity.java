package com.example.demo.Entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "train_route")
public class TrainRouteEntity {
    @Id
    private Long id;

    @Column(name = "train_id")
    private String trainId;

    private String origin;

    private String destination;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "arrive_time")
    private Timestamp arriveTime;

    private Double fee;


    @Column(name = "remaining_tickets")
    private Long remainingTickets;


    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
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
