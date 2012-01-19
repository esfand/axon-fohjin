package nijhof2axon.ui.activeAccount;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import nijhof2axon.app.command.WithdrawCashCommand;
import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.ui.MainWindow;
import nijhof2axon.ui.events.LedgerModificationCompletedEvent;
import org.axonframework.commandhandling.CommandBus;

import java.math.BigDecimal;

/**
 * User: Bahadir Konu (bah.konu@gmail.com)
 */
public class CashWithdrawalWindow extends Window {

    public CashWithdrawalWindow(final ActiveAccountEntry activeAccountEntry, final CommandBus commandBus) {
        setCaption("Withdraw Cash");

        setModal(true);

        setWidth("50%");

        center();

        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setHeight("50%");
        mainVerticalLayout.setSpacing(true);

        VerticalLayout buttonsLayout = new VerticalLayout();

        final TextField depositAmount = new TextField("Specify the amount to be withdrawn");

        mainVerticalLayout.addComponent(depositAmount);

        Button depositButton = new Button("Withdraw");

        depositButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {

                BigDecimal amount = BigDecimal.valueOf(new Double(depositAmount.getValue().toString()));

                WithdrawCashCommand depositCashCommand =
                        new WithdrawCashCommand(activeAccountEntry.getIdentifier(), amount);

                commandBus.dispatch(depositCashCommand);

                ((MainWindow) getApplication().getMainWindow()).fireEvent(new LedgerModificationCompletedEvent(activeAccountEntry));

                close();
            }
        });

        buttonsLayout.addComponent(depositButton);

        mainVerticalLayout.addComponent(buttonsLayout);

        addComponent(mainVerticalLayout);


    }


}


