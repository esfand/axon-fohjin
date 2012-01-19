package nijhof2axon.app.domain;

import nijhof2axon.app.event.ClientCreatedEvent;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import nijhof2axon.app.event.ClientNameChangedEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class Client extends AbstractAnnotatedAggregateRoot {

    private String name;
    private Address address;
    private String phoneNumber;

    public Client(AggregateIdentifier identifier) {
        super(identifier);
    }

    public Client(AggregateIdentifier identifier, String name) {
        this(identifier, name, null, null);
    }

    public Client(AggregateIdentifier identifier, String name, Address address, String phoneNumber) {
        super(identifier);
        apply(new ClientCreatedEvent(name, address, phoneNumber));
    }

    public String getName() {
        return name;
    }

    public ActiveAccount createNewActiveAccount(AggregateIdentifier accountIdentifier, String accountName, String accountNumber) {

        ActiveAccount activeAccount = new ActiveAccount(accountIdentifier, getIdentifier(), accountName, accountNumber);

        return activeAccount;
    }

    public void changeNameAs(String newName) {
        apply(new ClientNameChangedEvent(getIdentifier().asString(), newName));
    }

    @EventHandler
    private void handleClientNameChangedEvent(ClientNameChangedEvent event) {
        name = event.getNewName();
    }
}


