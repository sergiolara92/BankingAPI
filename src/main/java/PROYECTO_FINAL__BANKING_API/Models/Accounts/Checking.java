package PROYECTO_FINAL__BANKING_API.Models.Accounts;

import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import PROYECTO_FINAL__BANKING_API.Models.Users.User;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Checking extends Account{


    private BigDecimal minimumBalance = new BigDecimal("250.00");

    @NotEmpty
    private String secretKey;


    private BigDecimal monthlyMaintenanceFee = new BigDecimal("12.00");

    private LocalDate MaintenanceDate = this.getCreationDate();


    public Checking() {
    }

    public Checking(BigDecimal balance, User primaryOwner, User secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.minimumBalance = new BigDecimal("250.00");
        this.monthlyMaintenanceFee = new BigDecimal("12.00");
        this.secretKey = secretKey;
    }





    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public LocalDate getMaintenanceDate() {
        return MaintenanceDate;
    }

    public void setMaintenanceDate(LocalDate maintenanceDate) {
        MaintenanceDate = maintenanceDate;
    }



    public void applyMaintenanceFee(){
        if (LocalDate.now().getMonthValue() > this.getMaintenanceDate().getMonthValue() && LocalDate.now().getYear() >= this.getMaintenanceDate().getYear()) {
            for (int i = LocalDate.now().getMonthValue(); i > this.getMaintenanceDate().getMonthValue() ; i--) {
                this.setBalance(this.getBalance().subtract(monthlyMaintenanceFee));
            }
            this.setMaintenanceDate(LocalDate.now());
        }
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.minimumBalance = new BigDecimal("250.00");
        if (balance.compareTo(this.minimumBalance) < 0 ){
            super.setBalance(balance.subtract(getPenaltyFee()));
        }
        else if (balance.compareTo(this.minimumBalance) > 0) {
        super.setBalance(balance);
        }


    }





}
