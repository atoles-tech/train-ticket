package train_tickets.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Train {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<TrainCarriage> carriages;

    @OneToOne 
    private Shedule shedule;
    
    public Train() {
    }

    public Train(List<TrainCarriage> carriages, Shedule shedule) {
        this.carriages = carriages;
        this.shedule = shedule;
    }

    public Train(Long id, List<TrainCarriage> carriages, Shedule shedule) {
        this.id = id;
        this.carriages = carriages;
        this.shedule = shedule;
    }

    public void addCarriage(TrainCarriage carriage){
        if(carriages.contains(carriage)){throw new RuntimeException("Этот вагон уже добавлен!");}
        carriages.add(carriage);
        carriage.setAvailable(false);
    }

    public void removeCarriage(TrainCarriage carriage){
        carriages.remove(carriage);
        carriage.setAvailable(true);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TrainCarriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(List<TrainCarriage> carriages) {
        this.carriages = carriages;
    }

    public Shedule getShedule() {
        return shedule;
    }

    public void setShedule(Shedule shedule) {
        this.shedule = shedule;
    } 

    
    
}
