package nijhof2axon.app.commandHandler;

import nijhof2axon.app.domain.Client;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import nijhof2axon.app.command.ChangeClientNameCommand;
import org.axonframework.unitofwork.UnitOfWork;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ChangeClientNameCommandHandler {
    private Repository<Client> clientRepository;

    @CommandHandler
    public void handle(final ChangeClientNameCommand command, UnitOfWork unitOfWork) {

        Client client = clientRepository.load(new StringAggregateIdentifier(command.getClientIdentifier()));

        client.changeNameAs(command.getNewName());
    }

    public void setClientRepository(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }
}
