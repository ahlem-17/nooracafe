package noora.demo.Repository;

import java.util.Optional;

import noora.demo.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 
    Optional<User> findUserByEmail(String email);
}
