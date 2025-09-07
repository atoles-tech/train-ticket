package train_tickets.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Shedule {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<SheduleEvent> events;

    public Shedule() {
    }

    public Shedule(List<SheduleEvent> events) {
        this.events = events;
    }

    public Shedule(Long id, List<SheduleEvent> events) {
        this.id = id;
        this.events = events;
    }

    public void addEvent(SheduleEvent event){this.events.add(event);}

    public void removeEvent(SheduleEvent event){this.events.remove(event);}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SheduleEvent> getEvents() {
        return events;
    }

    public void setEvents(List<SheduleEvent> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Shedule [id=" + id + ", events=" + events + "]";
    }

}
