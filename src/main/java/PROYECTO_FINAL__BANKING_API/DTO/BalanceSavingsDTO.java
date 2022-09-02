package PROYECTO_FINAL__BANKING_API.DTO;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class BalanceSavingsDTO {

    @DecimalMin(value = "100.0", message = "Minimum Balance is 100")
    BigDecimal balance;

    public BalanceSavingsDTO() {
    }

    public BalanceSavingsDTO(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
