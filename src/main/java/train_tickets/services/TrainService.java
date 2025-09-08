package train_tickets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import train_tickets.model.Train;
import train_tickets.repositories.TrainRepository;

@Service
public class TrainService {

    private TrainRepository repository;

    public TrainService(TrainRepository repository) {
        this.repository = repository;
    }

    public void save(Train train){
        repository.save(train);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public List<Train> findAll(){
        return repository.findAll();
    }

    public Train getTrainByID(Long id){
        return repository.findById(id).get();
    }

    public Train createTrain(){
        Train train = new Train(List.of(), List.of());
        save(train);
        return train;
    }
}
