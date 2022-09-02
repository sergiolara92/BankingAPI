package PROYECTO_FINAL__BANKING_API.Repositories.Users;

import PROYECTO_FINAL__BANKING_API.Models.Users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
