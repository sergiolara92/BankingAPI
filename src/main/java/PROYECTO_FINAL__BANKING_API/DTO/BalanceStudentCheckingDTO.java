package PROYECTO_FINAL__BANKING_API.DTO;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class BalanceStudentCheckingDTO {

    @DecimalMin(value = "0.0", message = "Too Low")
    BigDecimal balance;

    public BalanceStudentCheckingDTO() {
    }

    public BalanceStudentCheckingDTO(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
