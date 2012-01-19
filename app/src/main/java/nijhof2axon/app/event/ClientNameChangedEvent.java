package nijhof2axon.app.event;

import org.axonframework.domain.DomainEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientNameChangedEvent extends DomainEvent {
    private String clientIdentifier;
    private String newName;

    public ClientNameChangedEvent(String clientIdentifier, String newName) {
        this.clientIdentifier = clientIdentifier;
        this.newName = newName;
    }

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
