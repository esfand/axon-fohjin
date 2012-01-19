package nijhof2axon.app.commandHandler;

import nijhof2axon.app.domain.Client;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import nijhof2axon.app.command.CreateClientCommand;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class CreateClientCommandHandler {

    private Repository<Client> clientRepository;

    @CommandHandler
    public void handle(final CreateClientCommand command, UnitOfWork unitOfWork) {
        Assert.notNull(command.getName(), "Client name may not be null");

        AggregateIdentifier id = new StringAggregateIdentifier(UUID.randomUUID().toString());
                                                     
        Client client = new Client(id, command.getName(), command.getAddress(), command.getPhoneNumber());

        clientRepository.add(client);
    }

    public void setClientRepository(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }
}
