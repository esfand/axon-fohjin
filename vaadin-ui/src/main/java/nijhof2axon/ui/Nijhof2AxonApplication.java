package nijhof2axon.ui;

import com.vaadin.Application;
import com.vaadin.ui.VerticalLayout;
import nijhof2axon.ui.activeAccount.*;
import nijhof2axon.ui.client.ChangeClientNameWindow;
import nijhof2axon.ui.client.ClientView;
import nijhof2axon.ui.data.ActiveAccountContainer;
import nijhof2axon.ui.data.LedgerContainer;
import nijhof2axon.ui.events.*;
import org.axonframework.commandhandling.CommandBus;
import nijhof2axon.ui.data.ClientContainer;
import nijhof2axon.ui.client.ClientDetailsView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class Nijhof2AxonApplication extends Application implements MediatorListener {

    protected MainWindow mainWindow;

    // Autowired beans
    public static ClientContainer clientContainer;
    public static ActiveAccountContainer activeAccountContainer;
    public static LedgerContainer ledgerContainer;
    public static CommandBus commandBus;

    private VerticalLayout mainVerticalLayout;
    private ClientView clientView;
    private ClientDetailsView clientDetailsView;
    private ActiveAccountView activeAccountView;

    @Override
    public void init() {

        setTheme("runo");

        mainWindow = new MainWindow();

        mainWindow.getContent().setSizeFull();

        mainVerticalLayout = new VerticalLayout();

        clientView = new ClientView();
        mainVerticalLayout.addComponent(clientView);

        mainWindow.setContent(mainVerticalLayout);

        clientDetailsView = new ClientDetailsView();
        activeAccountView = new ActiveAccountView();

        mainWindow.addCollaborator(clientView);
        mainWindow.addCollaborator(clientDetailsView);
        mainWindow.addCollaborator(activeAccountContainer);
        mainWindow.addCollaborator(this);
        mainWindow.addCollaborator(activeAccountView);

        setMainWindow(mainWindow);

    }

    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ClientSelectedEvent) {
            mainVerticalLayout.replaceComponent(clientView, clientDetailsView);
        }

        if (event instanceof ActiveAccountDetailsRequestedEvent) {
            mainVerticalLayout.replaceComponent(clientDetailsView, activeAccountView);
        }

        if (event instanceof ChangeClientNameRequestedEvent) {
            mainWindow.addWindow(new ChangeClientNameWindow(commandBus, ((ChangeClientNameRequestedEvent) event).getClientDetailsEntry()
            ));
        }

        if (event instanceof ClientListViewRequestedEvent) {
            mainVerticalLayout.replaceComponent(clientDetailsView, clientView);
        }

        if (event instanceof AddActiveAccountRequestedEvent) {
            mainWindow.addWindow(new AddActiveAccountWindow(commandBus, ((AddActiveAccountRequestedEvent) event).getClientDetailsEntry(),
                    activeAccountContainer));
        }

        if (event instanceof ClientDetailsViewRequestedEvent) {
            mainVerticalLayout.replaceComponent(activeAccountView, clientDetailsView);
        }

        if (event instanceof CashDepositeRequestedEvent) {
            mainWindow.addWindow(new CashDepositWindow(((CashDepositeRequestedEvent) event).getActiveAccountEntry(),
                    commandBus));
        }

        if (event instanceof CashWithdrawalRequestedEvent) {
            mainWindow.addWindow(new CashWithdrawalWindow(((CashWithdrawalRequestedEvent) event).getActiveAccountEntry(),
                    commandBus));
        }


    }

    @Override
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    @Autowired
    public void setClientContainer(ClientContainer clientContainer) {
        Nijhof2AxonApplication.clientContainer = clientContainer;
    }

    @Autowired
    public void setActiveAccountContainer(ActiveAccountContainer activeAccountContainer) {
        Nijhof2AxonApplication.activeAccountContainer = activeAccountContainer;
    }

    @Autowired
    public void setLedgerContainer(LedgerContainer ledgerContainer) {
        Nijhof2AxonApplication.ledgerContainer = ledgerContainer;
    }

    @Autowired
    public void setCommandBus(CommandBus commandBus) {
        Nijhof2AxonApplication.commandBus = commandBus;
    }
}
