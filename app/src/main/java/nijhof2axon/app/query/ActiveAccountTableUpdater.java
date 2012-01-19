package nijhof2axon.app.query;

import nijhof2axon.app.event.ActiveAccountOpenedEvent;
import nijhof2axon.app.event.CashDepositedEvent;
import nijhof2axon.app.event.CashWithdrawnEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ActiveAccountTableUpdater {
    @Autowired
    ActiveAccountRepository activeAccountRepository;

    @EventHandler
    public void handleActiveAccountOpenedEvent(ActiveAccountOpenedEvent event) {
        ActiveAccountEntry activeAccountEntry = new ActiveAccountEntry();
        activeAccountEntry.setClientIdentifier(event.getClientId().asString());
        activeAccountEntry.setAccountName(event.getAccountName());
        activeAccountEntry.setBalance(new BigDecimal(0));
        activeAccountEntry.setIdentifier(event.getAggregateIdentifier().asString());
        activeAccountEntry.setAccountNumber(event.getAccountNumber());

        activeAccountRepository.save(activeAccountEntry);
    }

    @EventHandler
    public void handleCashDepositedEvent(CashDepositedEvent event) {

        ActiveAccountEntry activeAccountEntry = activeAccountRepository.findById(event.getActiveAccountId());

        activeAccountEntry.setBalance(event.getNewBalance());

        activeAccountRepository.save(activeAccountEntry);
    }

    @EventHandler
    public void handleCashWithdrawnEvent(CashWithdrawnEvent event) {

        ActiveAccountEntry activeAccountEntry = activeAccountRepository.findById(event.getActiveAccountId());

        activeAccountEntry.setBalance(event.getNewBalance());

        activeAccountRepository.save(activeAccountEntry);
    }

}

