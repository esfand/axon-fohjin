package nijhof2axon.app.event;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.DomainEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class ActiveAccountOpenedEvent extends DomainEvent {
    private AggregateIdentifier clientId;
    private String accountName;
    private String accountNumber;

    public ActiveAccountOpenedEvent(AggregateIdentifier clientId, String accountName, String accountNumber) {
        this.clientId = clientId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public AggregateIdentifier getClientId() {
        return clientId;
    }

    public void setClientId(AggregateIdentifier clientId) {
        this.clientId = clientId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
