package nijhof2axon.app.commandHandler;

import nijhof2axon.app.command.ReceiveMoneyTransferCommand;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import nijhof2axon.app.domain.ActiveAccount;
import org.axonframework.unitofwork.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ReceiveMoneyTransferCommandHandler {

    private final static Logger logger = LoggerFactory.getLogger(ReceiveMoneyTransferCommandHandler.class);
    private Repository<ActiveAccount> repository;

    @CommandHandler
    public void handle(final ReceiveMoneyTransferCommand command, UnitOfWork unitOfWork) {
        logger.debug("Received a command for a new transfer for account : {}", command.getAccountNumber());
        Assert.notNull(command.getAccountNumber(), "Account Number may not be null");
        Assert.notNull(command.getAmount(), "Amount may not be null");

        ActiveAccount activeAccount = repository.load(command.getActiveAccountId());

        activeAccount.receiveTransferFrom(command.getAccountNumber(), command.getAmount());
    }

    public void setRepository(Repository<ActiveAccount> repository) {
        this.repository = repository;
    }
}
