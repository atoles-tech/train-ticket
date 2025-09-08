package train_tickets.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Train {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<TrainCarriage> carriages;
    
    @OneToMany
    private List<SheduleEvent> events;

    public Train() {
    }

    public Train(List<TrainCarriage> carriages, List<SheduleEvent> events) {
        this.carriages = carriages;
        this.events = events;
    }

    public Train(Long id, List<TrainCarriage> carriages, List<SheduleEvent> events) {
        this.id = id;
        this.carriages = carriages;
        this.events = events;
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

    public void addEvent(SheduleEvent event){
        this.events.add(event);
    }

    public void removeEvent(SheduleEvent event){
        this.events.remove(event);
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

    public List<SheduleEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SheduleEvent> events) {
        this.events = events;
    }
    
}
