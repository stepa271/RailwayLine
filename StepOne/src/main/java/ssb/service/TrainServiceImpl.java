package ssb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ssb.dao.TrainDAO;
import ssb.dao.TrainDAOImpl;
import ssb.model.Train;

import java.util.List;

@Repository
public class TrainServiceImpl implements TrainService{


    private TrainDAO trainDAO ;
    //=new TrainDAOImpl();



        @Autowired
        public void setTrainDAO(TrainDAO trainDAO){
            this.trainDAO=trainDAO;
        }

    @Override
    public List<Train> allTrains() {
        return trainDAO.allTrains();
    }

    @Override
    public void add(Train train) {
        trainDAO.add(train);

    }

    @Override
    public void delete(Train train) {
            trainDAO.delete(train);
    }

    @Override
    public void edit(Train train) {
            trainDAO.edit(train);
    }

    @Override
    public Train getById(int id) {
        return trainDAO.getById(id);
    }
}
