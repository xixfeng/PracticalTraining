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
        this.userId=((Integer)map.get("userId")).longValue();
        this.trainId=(String)map.get("trainId");
        this.fee=Double.parseDouble(map.get("fee").toString());
        this.discount=Double.parseDouble(map.get("discount").toString());
        this.orgin=(String)map.get("orgin");
        this.destination=(String)map.get("destination");
        this.type=(String)map.get("type");
        this.seat=(String)map.get("seat");
    }
    public TrainOrderEntity(){

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

    @Override
    public String toString() {
        return "TrainOrderEntity{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", trainId='" + trainId + '\'' +
                ", fee=" + fee +
                ", discount=" + discount +
                ", orgin='" + orgin + '\'' +
                ", destination='" + destination + '\'' +
                ", type='" + type + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
