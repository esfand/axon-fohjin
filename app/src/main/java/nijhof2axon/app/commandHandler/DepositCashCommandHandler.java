package nijhof2axon.app.commandHandler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import nijhof2axon.app.domain.ActiveAccount;
import nijhof2axon.app.command.DepositCashCommand;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.beans.factory.annotation.Required;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class DepositCashCommandHandler {

    private Repository<ActiveAccount> activeAccountRepository;

    @CommandHandler
    public void handle(final DepositCashCommand command, UnitOfWork unitOfWork) {

        AggregateIdentifier identifier = new StringAggregateIdentifier(command.getActiveAccountId());

        ActiveAccount activeAccount = activeAccountRepository.load(identifier);

        activeAccount.depositCash(command.getAmount());

    }

    @Required
    public void setActiveAccountRepository(Repository<ActiveAccount> activeAccountRepository) {
        this.activeAccountRepository = activeAccountRepository;
    }
}
