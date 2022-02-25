package ssb.service;

import ssb.model.Train;
import java.util.List;

public interface TrainService {
    List<Train> allTrains();
    void add(Train train);
    void delete (Train train);
    void edit(Train train);
    Train getById(int id);


}
