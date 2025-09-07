package train_tickets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import train_tickets.model.Shedule;
import train_tickets.model.Train;
import train_tickets.repositories.TrainRepository;

@Service
public class TrainService {

    private TrainRepository repository;
    private SheduleService sheduleService;

    public TrainService(TrainRepository repository, SheduleService sheduleService) {
        this.repository = repository;
        this.sheduleService = sheduleService;
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
        Shedule shedule = sheduleService.createNewShedule();

        Train train = new Train(List.of(), shedule);
        save(train);
        return train;
    }
}
