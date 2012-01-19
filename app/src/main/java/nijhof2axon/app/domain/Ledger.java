package nijhof2axon.app.domain;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class Ledger {

    private BigDecimal amount;

    public String accountNumber;

    public Ledger(BigDecimal amount, String accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
