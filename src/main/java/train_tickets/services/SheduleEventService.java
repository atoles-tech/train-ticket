package train_tickets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import train_tickets.model.SheduleEvent;
import train_tickets.repositories.SheduleEventRepository;

@Service
public class SheduleEventService {

    private SheduleEventRepository repository;

    public SheduleEventService(SheduleEventRepository repository) {
        this.repository = repository;
    }

    public List<SheduleEvent> findAll(SheduleEvent event){
        return repository.findAll();
    } 

    public void save(SheduleEvent event){
        repository.save(event);
    }

    public void delete(SheduleEvent event){
        repository.delete(event);
    }

    public SheduleEvent findById(Long id){
        return repository.findById(id).get();
    }

}
