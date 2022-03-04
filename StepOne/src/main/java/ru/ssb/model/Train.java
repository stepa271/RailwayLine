package ru.ssb.model;


import javax.persistence.*;

/* POJO (Plain Old Java Object) */
@Entity
@Table(name="train")
public class Train {
    @Id
    @Column(name = "TRAIN_NUMBER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainNumber;
    @Column(name = "CAPACITY")
    private int countPlace;

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(int countPlace) {
        this.countPlace = countPlace;
    }
}
