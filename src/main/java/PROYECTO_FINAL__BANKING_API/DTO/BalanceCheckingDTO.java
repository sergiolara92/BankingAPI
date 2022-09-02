package PROYECTO_FINAL__BANKING_API.DTO;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class BalanceCheckingDTO {

    @DecimalMin(value = "250.0", message = "Minimum Balance is 250")
    BigDecimal balance;

    public BalanceCheckingDTO() {
    }

    public BalanceCheckingDTO(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
