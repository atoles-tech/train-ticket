package train_tickets.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import train_tickets.model.User;
import train_tickets.model.util.Role;
import train_tickets.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public void register(String username, String password) {
        if (repository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        user.setRole(Role.ADMIN);
        user.setActive(true);

        repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    
    public void toggleUserActive(Long userId) {
        User user = repository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(!user.isActive());
        repository.save(user);
    }
    
    public void changeUserRole(Long userId, Role newRole) {
        User user = repository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(newRole);
        repository.save(user);
    }
    
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
}