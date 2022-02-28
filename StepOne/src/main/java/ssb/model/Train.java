package ssb.model;


import javax.persistence.*;

/* POJO (Plain Old Java Object) */
@Entity
@Table(name="train")
public class Train {
    @Id
    @Column(name = "idtrain")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="number_train")
    private String numberTrain;
    @Column(name = "id_station")
    private int idStation;
    @Column(name = "count_place")
    private int countPlace;




    public String getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(int countPlace) {
        this.countPlace = countPlace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){

        return "ID"+ getId()+"<br>"+
                "Номер поезда:"+getNumberTrain()+"<br>"+
                "Станция:"+getIdStation()+"<br>"+
                "Количество мест:"+getCountPlace();
    }
}
