package ar.com.alejandro.fullstackbackend.repositories;

import ar.com.alejandro.fullstackbackend.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
