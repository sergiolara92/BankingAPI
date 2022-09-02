package PROYECTO_FINAL__BANKING_API.Services.User;

import PROYECTO_FINAL__BANKING_API.DTO.AccountHolderDTO;
import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import PROYECTO_FINAL__BANKING_API.Models.Users.Address;
import PROYECTO_FINAL__BANKING_API.Models.Users.Role;
import PROYECTO_FINAL__BANKING_API.Repositories.Users.AccountHolderRepository;
import PROYECTO_FINAL__BANKING_API.Repositories.Users.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public AccountHolder createAccountHolder(AccountHolderDTO accountHolderDTO) {
        if (LocalDate.now().getYear() - accountHolderDTO.getDateOfBirth().getYear() < 18) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Holder must be 18 years old at least.");
        }
        Address primaryAddress = new Address(accountHolderDTO.getStreetName(), accountHolderDTO.getBuildingNumber(), accountHolderDTO.getPostalCode(), accountHolderDTO.getCity(), accountHolderDTO.getCountry());
        Address mailingAddress = new Address(accountHolderDTO.getMailingStreetName(), accountHolderDTO.getMailingBuildingNumber(), accountHolderDTO.getMailingPostalCode(), accountHolderDTO.getMailingCity(), accountHolderDTO.getMailingCountry());
        AccountHolder accountHolder = new AccountHolder(accountHolderDTO.getUsername(), passwordEncoder.encode(accountHolderDTO.getPassword()), accountHolderDTO.getName(), accountHolderDTO.getDateOfBirth(), primaryAddress, mailingAddress);
        accountHolderRepository.save(accountHolder);
        Role holderRole = new Role ("ACCOUNT HOLDER", accountHolder);
        roleRepository.save(holderRole);
        accountHolderRepository.save(accountHolder);
        return accountHolder;
    }
}
