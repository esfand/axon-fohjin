package nijhof2axon.ui.activeAccount;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.Nijhof2AxonApplication;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.data.ActiveAccountContainer;
import nijhof2axon.ui.events.*;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ActiveAccountDetailsForm extends MediatorVerticalLayout implements MediatorListener {

    private ActiveAccountEntry activeAccountEntry;

    private Label accountNameLabel;
    private Label accountNumberLabel;
    private Label balanceLabel;

    public ActiveAccountDetailsForm() {

        com.vaadin.ui.MenuBar menuBar = new com.vaadin.ui.MenuBar();

        MenuBar.MenuItem menuItemTransfer = menuBar.addItem("Transfer", null);

        menuItemTransfer.addItem("Make cash deposite", new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                fire(new CashDepositeRequestedEvent(activeAccountEntry));
            }
        });

        menuItemTransfer.addItem("Withdraw cash", new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                fire(new CashWithdrawalRequestedEvent(activeAccountEntry));
            }
        });

        addComponent(menuBar);


        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setSpacing(true);
        mainVerticalLayout.setWidth("50%");

        HorizontalLayout space = new HorizontalLayout();
        space.setHeight("40%");
        mainVerticalLayout.addComponent(space);

        Form captionForm = new Form();
        captionForm.setCaption("Active Account Details");
        mainVerticalLayout.addComponent(captionForm);

        accountNameLabel = addLabel(mainVerticalLayout, "Account Name: ");
        accountNumberLabel = addLabel(mainVerticalLayout, "Account Number: ");
        balanceLabel = addLabel(mainVerticalLayout, "Balance: ");

        Button backButton = new Button("Back");
        backButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                //BKONU: how to handle this?
                fire(new ClientDetailsViewRequestedEvent(null));
            }
        });

        mainVerticalLayout.addComponent(backButton);

        mainVerticalLayout.setComponentAlignment(backButton, Alignment.BOTTOM_LEFT);

        addComponent(mainVerticalLayout);


    }

    //BKONU: duplicated at ActiveAccountDetails

    private Label addLabel(VerticalLayout verticalLayout, String caption) {

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);

        Label captionLabel = new Label(caption);
        captionLabel.setWidth("80px");
        captionLabel.addStyleName(Runo.LAYOUT_DARKER);
        Label valueLabel = new Label();
        layout.addComponent(captionLabel);
        layout.addComponent(valueLabel);

        verticalLayout.addComponent(layout);

        return valueLabel;
    }

    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ActiveAccountDetailsRequestedEvent) {
            refreshFor(((ActiveAccountDetailsRequestedEvent) event).getActiveAccountEntry());
        }

        if (event instanceof LedgerModificationCompletedEvent) {
            refreshFor(((LedgerModificationCompletedEvent) event).getActiveAccountEntry());
        }

    }

    public void refreshFor(ActiveAccountEntry activeAccountEntry) {
        this.activeAccountEntry = Nijhof2AxonApplication.activeAccountContainer.refresh(activeAccountEntry);

        accountNameLabel.setValue(this.activeAccountEntry.getAccountName());
        accountNumberLabel.setValue(this.activeAccountEntry.getAccountNumber());
        balanceLabel.setValue(this.activeAccountEntry.getBalance());
    }


}
