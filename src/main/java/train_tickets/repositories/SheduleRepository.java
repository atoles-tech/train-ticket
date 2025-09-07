package train_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.Shedule;

public interface SheduleRepository extends JpaRepository<Shedule, Long>{
    
}
