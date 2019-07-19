package com.example.demo.Entity;
import javax.persistence.*;

@Entity(name = "train")
public class TrainEntity {
    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainId;

    private String type;
}