package PROYECTO_FINAL__BANKING_API.Services;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Checking;
import PROYECTO_FINAL__BANKING_API.Models.Accounts.CreditCard;
import PROYECTO_FINAL__BANKING_API.Repositories.Accounts.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCard> allCreditCardAccounts() {
        return creditCardRepository.findAll();
    }




}
