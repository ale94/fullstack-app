package ar.com.alejandro.fullstackbackend.controllers;

import ar.com.alejandro.fullstackbackend.models.UserEntity;
import ar.com.alejandro.fullstackbackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;

    @PostMapping("/users")
    UserEntity newUser(@RequestBody UserEntity user) {
        return repository.save(user);
    }
}
