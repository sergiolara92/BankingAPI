package PROYECTO_FINAL__BANKING_API.Repositories.Users;

import PROYECTO_FINAL__BANKING_API.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
