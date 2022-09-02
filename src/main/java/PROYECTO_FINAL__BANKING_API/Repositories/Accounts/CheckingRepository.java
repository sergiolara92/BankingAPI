package PROYECTO_FINAL__BANKING_API.Repositories.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long>{


}
