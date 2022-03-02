package ru.ssb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.ssb.dao.TrainDAO;
import ru.ssb.dao.TrainDAOImpl;
import ru.ssb.model.Train;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService{


    private TrainDAO trainDAO=new TrainDAOImpl();

    @Autowired
    public void setTrainDAO(TrainDAO trainDAO)
        {
            this.trainDAO=trainDAO;
        }
    @Transactional
    @Override
    public List<Train> allTrains()
    {
        return trainDAO.allTrains();
    }
    @Transactional
    @Override
    public void add(Train train) {
        trainDAO.add(train);    }
    @Transactional
    @Override
    public void delete(Train train) {
            trainDAO.delete(train);
    }
    @Transactional
    @Override
    public void edit(Train train) {
            trainDAO.edit(train);
    }
    @Transactional
    @Override
    public Train getById(int id) {
        return trainDAO.getById(id);
    }
}
