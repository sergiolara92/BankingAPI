package PROYECTO_FINAL__BANKING_API.Controllers.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Savings;
import PROYECTO_FINAL__BANKING_API.Services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SavingsController {


    @Autowired
    SavingsService savingsService;


    @GetMapping("/all-savings-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Savings> allSavingsAccounts() {
        return savingsService.allSavingsAccounts();
    }
}
