package PROYECTO_FINAL__BANKING_API.Controllers.Accounts;

import PROYECTO_FINAL__BANKING_API.DTO.AccountHolderDTO;
import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import PROYECTO_FINAL__BANKING_API.Services.User.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController {

    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("/create-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO) {
        return accountHolderService.createAccountHolder(accountHolderDTO);
    }
}
