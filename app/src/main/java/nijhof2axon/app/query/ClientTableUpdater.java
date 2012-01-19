package nijhof2axon.app.query;

import nijhof2axon.app.event.ClientCreatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import nijhof2axon.app.event.ClientNameChangedEvent;
import org.springframework.beans.factory.annotation.Required;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientTableUpdater {
    private ClientRepository clientRepository;

    @EventHandler
    public void handleClientCreatedEvent(ClientCreatedEvent event) {
        ClientDetailsEntry entry = new ClientDetailsEntry();
        entry.setIdentifier(event.getClientIdentifier());
        entry.setClientName(event.getName());
        entry.setCity(event.getAddress().getCity());
        entry.setPhoneNumber(event.getPhoneNumber());
        entry.setPostalCode(event.getAddress().getPostalCode());
        entry.setStreet(event.getAddress().getStreet());
        entry.setStreetNumber(event.getAddress().getStreetNumber());
        
        clientRepository.persist(entry);
    }

    @EventHandler
    public void handleClientNameChangedEvent(ClientNameChangedEvent event) {
        ClientDetailsEntry clientEntry = clientRepository.findByIdentifier(event.getClientIdentifier());
        clientEntry.setClientName(event.getNewName());

        clientRepository.persist(clientEntry);
    }

    @Required
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}

