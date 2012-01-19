package nijhof2axon.ui.activeAccount;

import com.vaadin.ui.Table;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.Nijhof2AxonApplication;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.data.LedgerContainer;
import nijhof2axon.ui.events.ActiveAccountDetailsRequestedEvent;
import nijhof2axon.ui.events.LedgerModificationCompletedEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class LedgerList extends MediatorVerticalLayout implements MediatorListener {
    public LedgerList() {
        final Table ledgersTable = new Table("Ledgers");
        ledgersTable.setContainerDataSource(Nijhof2AxonApplication.ledgerContainer);

        ledgersTable.setVisibleColumns(new String[]{"action", "amount"});

        ledgersTable.setColumnHeader("action", "Action");
        ledgersTable.setColumnHeader("amount", "Amount");

        addComponent(ledgersTable);
    }

    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ActiveAccountDetailsRequestedEvent) {
            Nijhof2AxonApplication.ledgerContainer.refreshContent(((ActiveAccountDetailsRequestedEvent) event).getActiveAccountEntry().getIdentifier());
        }

        if (event instanceof LedgerModificationCompletedEvent) {
            Nijhof2AxonApplication.ledgerContainer.refreshContent(((LedgerModificationCompletedEvent) event).getActiveAccountEntry().getIdentifier());
        }

    }
}
