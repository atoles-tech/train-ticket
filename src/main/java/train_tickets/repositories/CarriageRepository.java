package train_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.TrainCarriage;

public interface CarriageRepository extends JpaRepository<TrainCarriage,Long>{

}
