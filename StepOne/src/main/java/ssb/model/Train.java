package ssb.model;


/* POJO (Plain Old Java Object) */
public class Train {
    private int id;
    private String numberTrain;
    private int idStation;
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
