package nijhof2axon.ui.activeAccount;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import nijhof2axon.app.command.OpenNewAccountForClientCommand;
import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.MainWindow;
import nijhof2axon.ui.data.ActiveAccountContainer;
import nijhof2axon.ui.events.ActiveAccountCreatedEvent;
import org.axonframework.commandhandling.CommandBus;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class AddActiveAccountWindow extends Window {

    private ActiveAccountEntry activeAccountEntry;

    public AddActiveAccountWindow(final CommandBus commandBus, final ClientDetailsEntry clientEntry,
                                  final ActiveAccountContainer activeAccountContainer) {
        setCaption("Open Active Account");

        setModal(true);

        setWidth("50%");

        center();

        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setHeight("50%");
        mainVerticalLayout.setSpacing(true);

        final Form activeAccountForm = new Form();
        activeAccountForm.setWriteThrough(false);
        activeAccountForm.setInvalidCommitted(false);

        VerticalLayout formLayout = new VerticalLayout();
        formLayout.setCaption("Open Active Account");
        formLayout.setSpacing(true);

        activeAccountForm.setLayout(formLayout);

        activeAccountEntry = new ActiveAccountEntry();
        BeanItem<ActiveAccountEntry> item = new BeanItem<ActiveAccountEntry>(activeAccountEntry);
        item.removeItemProperty("identifier");
        item.removeItemProperty("clientIdentifier");
        item.removeItemProperty("balance");

        activeAccountForm.setFormFieldFactory(new ActiveAccountFormFieldFactory());
        activeAccountForm.setItemDataSource(item);


        mainVerticalLayout.addComponent(activeAccountForm);

        VerticalLayout buttonsLayout = new VerticalLayout();

        Button openActiveAccountButton = new Button("Open");

        openActiveAccountButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                try {
                    activeAccountForm.commit();


                    OpenNewAccountForClientCommand command = new OpenNewAccountForClientCommand(clientEntry.getIdentifier(),
                            activeAccountEntry.getAccountName(), activeAccountEntry.getAccountNumber());

                    commandBus.dispatch(command);

                    ((MainWindow) getApplication().getMainWindow()).fireEvent(
                            new ActiveAccountCreatedEvent(clientEntry.getIdentifier()));

                    close();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }


            }
        });

        buttonsLayout.addComponent(openActiveAccountButton);

        mainVerticalLayout.addComponent(buttonsLayout);

        addComponent(mainVerticalLayout);


    }


}
