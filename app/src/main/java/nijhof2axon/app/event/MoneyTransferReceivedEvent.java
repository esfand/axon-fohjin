package nijhof2axon.app.event;

import org.axonframework.domain.DomainEvent;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class MoneyTransferReceivedEvent extends DomainEvent {
    BigDecimal newBalance;
    BigDecimal amount;
    String sourceAccountNumber;
    String targetAccountNumber;

    public MoneyTransferReceivedEvent(BigDecimal newBalance, BigDecimal amount, String sourceAccountNumber, String accountNumber) {

    }

    public BigDecimal getNewBalance() {
        return newBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }
}
