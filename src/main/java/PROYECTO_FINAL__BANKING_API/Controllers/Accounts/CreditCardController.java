package PROYECTO_FINAL__BANKING_API.Controllers.Accounts;


import PROYECTO_FINAL__BANKING_API.Models.Accounts.CreditCard;
import PROYECTO_FINAL__BANKING_API.Services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/all-credit-card-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> allCreditCardAccounts() {
        return creditCardService.allCreditCardAccounts();
    }

    // post para crear cc
    //put/patch en cada uno para transfers
}
