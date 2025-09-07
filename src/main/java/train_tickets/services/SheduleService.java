package train_tickets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import train_tickets.model.Shedule;
import train_tickets.repositories.SheduleRepository;

@Service
public class SheduleService {
    
    private SheduleRepository repository;

    public SheduleService(SheduleRepository repository) {
        this.repository = repository;
    }

    public List<Shedule> findAll(){
        return repository.findAll();
    }

    public void save(Shedule shedule){
        repository.save(shedule);
    }

    public Shedule createNewShedule(){
        Shedule shedule = new Shedule();
        save(shedule);
        return shedule;
    }

}
