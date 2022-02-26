package ssb.dao;


import org.springframework.stereotype.Repository;
import ssb.model.Train;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TrainDAOImpl implements TrainDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Train> trains=new HashMap<>();

    static {
        Train train1= new Train();
        train1.setId(AUTO_ID.getAndIncrement());
        train1.setNumberTrain("#052 Spb-Adler");
        train1.setCountPlace(99);
        train1.setIdStation(23);
        trains.put(train1.getId(),train1);
    }


    @Override
    public List<Train> allTrains() {
        return new ArrayList<>(trains.values());
    }

    @Override
    public void add(Train train) {
        train.setId(AUTO_ID.getAndIncrement());
        trains.put(train.getId(),train);

    }

    @Override
    public void delete(Train train) {
        trains.remove(train.getId());

    }

    @Override
    public void edit(Train train) {
        trains.put(train.getId(),train);
    }

    @Override
    public Train getById(int id) {
        return trains.get(id);
    }
}
