package nijhof2axon.app.query;

import nijhof2axon.app.event.CashWithdrawnEvent;
import nijhof2axon.app.event.MoneyTransferReceivedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import nijhof2axon.app.event.CashDepositedEvent;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class LedgerTableUpdater {
    @PersistenceContext
    private EntityManager entityManager;

    @EventHandler
    public void handleCashDepositedEvent(CashDepositedEvent event) {
        LedgerEntry ledgerEntry = new LedgerEntry(event.getActiveAccountId(), event.getAmount(), "Deposit");

        entityManager.persist(ledgerEntry);
    }

    @EventHandler
    public void handleCashWithdrawnEvent(CashWithdrawnEvent event) {
        LedgerEntry ledgerEntry = new LedgerEntry(event.getActiveAccountId(), event.getAmount(), "Withdrawal");

        entityManager.persist(ledgerEntry);
    }

    @EventHandler
    public void handleMoneyTransferReceivedEvent(MoneyTransferReceivedEvent event) {
        LedgerEntry ledgerEntry = new LedgerEntry(event.getAggregateIdentifier().asString()
                , event.getAmount(),
                String.format("Transfer from {0} to {1}", event.getSourceAccountNumber(), event.getTargetAccountNumber()));

        entityManager.persist(ledgerEntry);
    }


}

