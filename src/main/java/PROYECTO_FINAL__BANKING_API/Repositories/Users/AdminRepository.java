package PROYECTO_FINAL__BANKING_API.Repositories.Users;

import PROYECTO_FINAL__BANKING_API.Models.Users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
