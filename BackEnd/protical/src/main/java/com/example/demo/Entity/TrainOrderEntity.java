package com.example.demo.Entity;
import javax.persistence.*;
import java.util.Map;

@Entity(name = "train_order")
public class TrainOrderEntity {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long userId;

    private String trainId;

    private Double fee;

    private Double discount;

    private String orgin;

    private String destination;

    private String type;

    private String seat;
    public TrainOrderEntity(Map map){
        this.userId=Long.valueOf((String)map.get("userId"));
        this.trainId=(String)map.get("trainId");
        this.fee=Double.parseDouble((String)map.get("fee"));
        this.discount=Double.parseDouble((String)map.get("diacount"));
        this.orgin=(String)map.get("orgin");
        this.destination=(String)map.get("destination");
        this.type=(String)map.get("type");
        this.seat=(String)map.get("seat");
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
