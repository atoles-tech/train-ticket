package train_tickets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    @OneToOne
    private Train train;

    @OneToOne
    private TrainCarriage carriage;
    
    @OneToOne
    private SheduleEvent event;

    public Ticket() {
    }

    public Ticket(Double price, Train train, TrainCarriage carriage, SheduleEvent event) {
        this.price = price;
        this.train = train;
        this.carriage = carriage;
        this.event = event;
    }

    public Ticket(Long id, Double price, Train train, TrainCarriage carriage, SheduleEvent event) {
        this.id = id;
        this.price = price;
        this.train = train;
        this.carriage = carriage;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public TrainCarriage getCarriage() {
        return carriage;
    }

    public void setCarriage(TrainCarriage carriage) {
        this.carriage = carriage;
    }

    public SheduleEvent getEvent() {
        return event;
    }

    public void setEvent(SheduleEvent event) {
        this.event = event;
    }

    
    
}
