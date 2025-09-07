package train_tickets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import train_tickets.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
