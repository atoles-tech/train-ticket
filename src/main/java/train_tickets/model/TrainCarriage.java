package train_tickets.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TrainCarriage {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TypeTrainCarriage typeCarriege;

    @OneToMany(mappedBy = "carriage", cascade = CascadeType.ALL)
    private Set<Seat> seats;
    
    private boolean isAvailable;

    public TrainCarriage() {
    }

    public TrainCarriage(TypeTrainCarriage typeCarriege, Set<Seat> seats, boolean isAvailable) {
        this.typeCarriege = typeCarriege;
        this.seats = seats;
        this.isAvailable = isAvailable;
    }

    public TrainCarriage(Long id, TypeTrainCarriage typeCarriege, Set<Seat> seats, boolean isAvailable) {
        this.id = id;
        this.typeCarriege = typeCarriege;
        this.seats = seats;
        this.isAvailable = isAvailable;
    }

    public void addSeat(Seat seat){
        if(seats.contains(seat)){throw new RuntimeException("Вагон содержит данное сиденье");}
        seats.add(seat);
    }

    public void removeSeat(Seat seat){
        seats.remove(seat);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeTrainCarriage getTypeCarriege() {
        return typeCarriege;
    }

    public void setTypeCarriege(TypeTrainCarriage typeCarriege) {
        this.typeCarriege = typeCarriege;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
}
