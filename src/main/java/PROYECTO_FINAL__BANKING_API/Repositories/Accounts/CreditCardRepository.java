package PROYECTO_FINAL__BANKING_API.Repositories.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
