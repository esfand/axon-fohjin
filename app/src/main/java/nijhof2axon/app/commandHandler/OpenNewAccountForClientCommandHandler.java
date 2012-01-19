package nijhof2axon.app.commandHandler;

import nijhof2axon.app.command.OpenNewAccountForClientCommand;
import nijhof2axon.app.domain.ActiveAccount;
import nijhof2axon.app.domain.Client;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class OpenNewAccountForClientCommandHandler {

    private Repository<Client> clientRepository;
    private Repository<ActiveAccount> activeAccountRepository;

    @CommandHandler
    public void handle(final OpenNewAccountForClientCommand command, UnitOfWork unitOfWork) {
        Assert.notNull(command.getAccountName(), "Account Name may not be null");
        Assert.notNull(command.getClientId(), "Client may not be null");

        Client client = clientRepository.load(new StringAggregateIdentifier(command.getClientId()));

        String accountId = command.getAccountId();
        if (accountId == null) {
            accountId = UUID.randomUUID().toString();
        }

        ActiveAccount activeAccount = client.createNewActiveAccount(new StringAggregateIdentifier(accountId), command.getAccountName(), command.getAccountNumber());

        activeAccountRepository.add(activeAccount);
    }

    @Required
    public void setClientRepository(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Required
    public void setActiveAccountRepository(Repository<ActiveAccount> activeAccountRepository) {
        this.activeAccountRepository = activeAccountRepository;
    }


}

