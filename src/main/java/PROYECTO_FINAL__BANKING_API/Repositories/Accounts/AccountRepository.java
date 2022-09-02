package PROYECTO_FINAL__BANKING_API.Repositories.Accounts;


import PROYECTO_FINAL__BANKING_API.Models.Accounts.Account;

import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import PROYECTO_FINAL__BANKING_API.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    List<Account>findAll();




    List<Account> findByPrimaryOwner(User user);



}
