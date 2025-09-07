package train_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.Train;

public interface TrainRepository extends JpaRepository<Train,Long>{
    
}
