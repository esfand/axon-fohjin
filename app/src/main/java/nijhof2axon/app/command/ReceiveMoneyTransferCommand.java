package nijhof2axon.app.command;

import org.axonframework.domain.AggregateIdentifier;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ReceiveMoneyTransferCommand {

    private AggregateIdentifier activeAccountId;
    private BigDecimal amount;
    private String accountNumber;

    public ReceiveMoneyTransferCommand(AggregateIdentifier activeAccountId, BigDecimal amount, String accountNumber) {
        this.activeAccountId = activeAccountId;
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AggregateIdentifier getActiveAccountId() {
        return activeAccountId;
    }

}
