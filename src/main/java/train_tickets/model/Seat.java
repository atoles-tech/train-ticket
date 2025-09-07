package train_tickets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String nameOfSeat;

    @ManyToOne
    @JoinColumn(name = "carriage_id")
    private TrainCarriage carriage;

    private boolean isAvailable;

    public Seat() {
    }

    public Seat(String nameOfSeat, TrainCarriage carriage, boolean isAvailable) {
        this.nameOfSeat = nameOfSeat;
        this.carriage = carriage;
        this.isAvailable = isAvailable;
    }

    public Seat(Long id, String nameOfSeat, TrainCarriage carriage, boolean isAvailable) {
        this.id = id;
        this.nameOfSeat = nameOfSeat;
        this.carriage = carriage;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfSeat() {
        return nameOfSeat;
    }

    public void setNameOfSeat(String nameOfSeat) {
        this.nameOfSeat = nameOfSeat;
    }

    public TrainCarriage getCarriage() {
        return carriage;
    }

    public void setCarriage(TrainCarriage carriage) {
        this.carriage = carriage;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return nameOfSeat;
    }

    
}
