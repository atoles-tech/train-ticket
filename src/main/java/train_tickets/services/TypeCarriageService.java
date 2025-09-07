package train_tickets.services;

import java.util.List;

import org.springframework.stereotype.Service;

import train_tickets.model.TypeTrainCarriage;
import train_tickets.repositories.TypeCarriageRepository;

@Service
public class TypeCarriageService {
    
    private TypeCarriageRepository repository;

    public TypeCarriageService(TypeCarriageRepository repository) {
        this.repository = repository;
    }

    public void save(TypeTrainCarriage type){
        repository.save(type);
    }

    public List<TypeTrainCarriage> findAll(){
        return repository.findAll();
    }

    public TypeTrainCarriage findByName(String name){
        return repository.findByName(name).get();
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public TypeTrainCarriage findById(Long id){return repository.findById(id).get();}

}
