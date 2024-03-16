package ar.com.alejandro.fullstackbackend.controllers;

import ar.com.alejandro.fullstackbackend.exceptions.UserNotFoundException;
import ar.com.alejandro.fullstackbackend.models.UserEntity;
import ar.com.alejandro.fullstackbackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping("/users")
    UserEntity newUser(@RequestBody UserEntity user) {
        return repository.save(user);
    }

    @GetMapping("/users")
    List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    UserEntity getUserById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    UserEntity updateUser(@RequestBody UserEntity newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    return repository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable Long id) {
        repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        repository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }
}
