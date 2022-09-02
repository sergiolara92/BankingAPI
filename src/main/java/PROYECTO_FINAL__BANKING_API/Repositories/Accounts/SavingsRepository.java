package PROYECTO_FINAL__BANKING_API.Repositories.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
