package PROYECTO_FINAL__BANKING_API.Services;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Account;
import PROYECTO_FINAL__BANKING_API.Models.Accounts.Checking;
import PROYECTO_FINAL__BANKING_API.Repositories.Accounts.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingService {

    @Autowired
    CheckingRepository checkingRepository;

    public List<Checking> allCheckingAccounts() {
        return checkingRepository.findAll();
    }




}
