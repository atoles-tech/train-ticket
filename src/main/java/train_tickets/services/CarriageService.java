package train_tickets.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import train_tickets.model.Seat;
import train_tickets.model.TrainCarriage;
import train_tickets.model.TypeTrainCarriage;
import train_tickets.repositories.CarriageRepository;

@Service
public class CarriageService {
    
    private CarriageRepository repository;
    
    private TypeCarriageService typeCarriageService;

    public CarriageService(CarriageRepository repository, TypeCarriageService typeCarriageService) {
        this.repository = repository;
        this.typeCarriageService = typeCarriageService;
    }

    public List<TrainCarriage> findAll(){return repository.findAll();}

    public List<TrainCarriage> findAllAvailable(){
        return findAll().stream().filter(x->x.isAvailable()).toList();
    }

    public TrainCarriage findTrainCarriageById(Long id){return repository.findById(id).get();}

    public void save(TrainCarriage carriage){repository.save(carriage);}

    public void deleteById(Long id){repository.deleteById(id);}

    public List<TypeTrainCarriage> findAllTypes(){return typeCarriageService.findAll();}

    public TypeTrainCarriage findById(Long id){return typeCarriageService.findById(id);} //?

    public TrainCarriage generateCarriage(Integer capacity, Integer countRow, TypeTrainCarriage type){

        TrainCarriage carriage = new TrainCarriage();
        
        carriage.setTypeCarriege(type);
        carriage.setSeats(generateSeats(capacity,countRow,carriage));
        carriage.setAvailable(true);

        return carriage;
    }

    private Set<Seat> generateSeats(Integer capacity, Integer countRow, TrainCarriage carriage){
        Set<Seat> seats = new HashSet<>();

        for(int j = 0;j<countRow;j++){
            for(int i = 0;i < capacity/countRow;i++){
                seats.add(new Seat(
                    new StringBuilder().append(j+1).append(i).toString(),
                    carriage,
                    true));
            }
        }

        return seats;
    }
}
