package PROYECTO_FINAL__BANKING_API.Repositories.Users;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Account;
import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    Optional<AccountHolder> findByName(String name);

    Optional<AccountHolder> findByUsername(String username);




}
