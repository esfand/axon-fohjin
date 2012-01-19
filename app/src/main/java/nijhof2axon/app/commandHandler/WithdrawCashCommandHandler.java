package nijhof2axon.app.commandHandler;

import nijhof2axon.app.command.WithdrawCashCommand;
import nijhof2axon.app.domain.ActiveAccount;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.StringAggregateIdentifier;
import org.axonframework.repository.Repository;
import org.axonframework.unitofwork.UnitOfWork;
import org.springframework.beans.factory.annotation.Required;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class WithdrawCashCommandHandler {

    private Repository<ActiveAccount> activeAccountRepository;

    @CommandHandler
    public void handle(final WithdrawCashCommand command, UnitOfWork unitOfWork) {

        AggregateIdentifier identifier = new StringAggregateIdentifier(command.getActiveAccountId());

        ActiveAccount activeAccount = activeAccountRepository.load(identifier);

        activeAccount.withdrawCash(command.getAmount());

    }

    @Required
    public void setActiveAccountRepository(Repository<ActiveAccount> activeAccountRepository) {
        this.activeAccountRepository = activeAccountRepository;
    }
}
