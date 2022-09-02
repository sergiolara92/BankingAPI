package PROYECTO_FINAL__BANKING_API.Services;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.CreditCard;
import PROYECTO_FINAL__BANKING_API.Models.Accounts.Savings;
import PROYECTO_FINAL__BANKING_API.Repositories.Accounts.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsService {

    @Autowired
    SavingsRepository savingsRepository;


    public List<Savings> allSavingsAccounts() {
        return savingsRepository.findAll();
    }
}
