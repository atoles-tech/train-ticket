package train_tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.SheduleEvent;

public interface SheduleEventRepository extends JpaRepository<SheduleEvent,Long>{
    
}
