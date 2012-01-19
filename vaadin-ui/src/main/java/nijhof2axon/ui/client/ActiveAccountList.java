package nijhof2axon.ui.client;

import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.Nijhof2AxonApplication;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.data.ActiveAccountContainer;
import nijhof2axon.ui.events.ActiveAccountDetailsRequestedEvent;
import nijhof2axon.ui.events.ChangeClientNameCompletedEvent;
import nijhof2axon.ui.events.ClientSelectedEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ActiveAccountList extends MediatorVerticalLayout implements MediatorListener {

    public ActiveAccountList() {

        VerticalLayout mainVerticalLayout = new VerticalLayout();

        mainVerticalLayout.addComponent(getActiveAccountsTable());

        addComponent(mainVerticalLayout);
    }

    @Override
    public void handleEvent(UIEvent event) {

        if (event instanceof ClientSelectedEvent) {
            Nijhof2AxonApplication.activeAccountContainer.refreshContent(((ClientSelectedEvent) event).getSelectedClient().getIdentifier());
        }

        if (event instanceof ChangeClientNameCompletedEvent) {
            Nijhof2AxonApplication.activeAccountContainer.refreshContent(((ChangeClientNameCompletedEvent) event).getClientEntry().getIdentifier());
        }

    }

    private Table getActiveAccountsTable() {
        final Table activeAccountsTable = new Table("Active Accounts");
        activeAccountsTable.setContainerDataSource(Nijhof2AxonApplication.activeAccountContainer);

        activeAccountsTable.setVisibleColumns(new String[]{"accountName", "accountNumber", "balance"});

        activeAccountsTable.setColumnHeader("accountName", "Account Name");
        activeAccountsTable.setColumnHeader("accountNumber", "Account Number");
        activeAccountsTable.setColumnHeader("balance", "Balance");

        activeAccountsTable.addListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {

                BeanItem beanItem = (BeanItem) event.getItem();

                ActiveAccountEntry activeAccountEntry = (ActiveAccountEntry) beanItem.getBean();

                fire(new ActiveAccountDetailsRequestedEvent(activeAccountEntry));

            }
        });

        return activeAccountsTable;

    }


}
