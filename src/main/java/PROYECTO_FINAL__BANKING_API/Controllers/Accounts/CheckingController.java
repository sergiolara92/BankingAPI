package PROYECTO_FINAL__BANKING_API.Controllers.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Accounts.Checking;
import PROYECTO_FINAL__BANKING_API.Services.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckingController {

    @Autowired
    CheckingService checkingService;


    @GetMapping("/all-checking-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Checking> allCheckingAccounts() {
        return checkingService.allCheckingAccounts();
    }
}
