package train_tickets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.TypeTrainCarriage;

public interface TypeCarriageRepository extends JpaRepository<TypeTrainCarriage,Long>{
    Optional<TypeTrainCarriage> findByName(String name);
}
