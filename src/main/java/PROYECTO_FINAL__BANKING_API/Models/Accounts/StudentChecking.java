package PROYECTO_FINAL__BANKING_API.Models.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Users.User;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity

public class StudentChecking extends Account{

    @NotEmpty
    private String secretKey;

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, User primaryOwner, User secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


}
