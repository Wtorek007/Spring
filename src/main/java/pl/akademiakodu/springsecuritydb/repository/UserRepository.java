package pl.akademiakodu.springsecuritydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akademiakodu.springsecuritydb.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String username);
}