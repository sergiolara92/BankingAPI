package PROYECTO_FINAL__BANKING_API.Models.Accounts;

import PROYECTO_FINAL__BANKING_API.Enums.Status;
import PROYECTO_FINAL__BANKING_API.Models.Users.AccountHolder;
import PROYECTO_FINAL__BANKING_API.Models.Users.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull
    private User primaryOwner;
    @ManyToOne
    @JoinColumn(name = "second_owner_id")
    private User secondaryOwner;
    private BigDecimal penaltyFee;
    private LocalDate creationDate;
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;


    public Account() {
    }



    public Account(BigDecimal balance, User primaryOwner, User secondaryOwner) {
        penaltyFee = new BigDecimal("40.00");
        setBalance(balance);
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        creationDate = LocalDate.now();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public User getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void applyPenaltyFee() {
        this.setBalance(this.getBalance().subtract(this.getPenaltyFee()));
    }

    public void freezeAccount(){
        //poner las condiciones que hay que cumplir para congelar la cuenta
        this.setStatus(Status.FROZEN);
    }//TODO  -> CREAR SERVICE PARA FREEZEAR CUENTAS O AÑADIRLO AL FINAL DE CADA SERVICE?? ** HACER QUE SI ESTÁ FROZEN NO SE PUEDE HACER NADA
}
