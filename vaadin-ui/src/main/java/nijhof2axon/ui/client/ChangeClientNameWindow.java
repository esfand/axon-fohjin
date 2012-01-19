package nijhof2axon.ui.client;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import nijhof2axon.app.command.ChangeClientNameCommand;
import nijhof2axon.app.query.ClientDetailsEntry;
import org.axonframework.commandhandling.CommandBus;
import nijhof2axon.ui.MainWindow;
import nijhof2axon.ui.events.ChangeClientNameCompletedEvent;

/**
 * User: Bahadir Konu (bah.konu@gmail.com)
 */
public class ChangeClientNameWindow extends Window {

    public ChangeClientNameWindow(final CommandBus commandBus, final ClientDetailsEntry clientEntry) {
        setCaption("Change Client Name");

        setModal(true);

        setWidth("50%");

        center();

        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setHeight("50%");
        mainVerticalLayout.setSpacing(true);

        final TextField textField = new TextField("New name:");
        mainVerticalLayout.addComponent(textField);

        VerticalLayout buttonsLayout = new VerticalLayout();

        Button changeClientNameButton = new Button("Change");

        changeClientNameButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                try {

                    String newName = textField.getValue().toString();

                    ChangeClientNameCommand command = new ChangeClientNameCommand(clientEntry.getIdentifier(),
                            newName);

                    commandBus.dispatch(command);

                    clientEntry.setClientName(newName);
                    ((MainWindow) getApplication().getMainWindow()).fireEvent(new ChangeClientNameCompletedEvent(clientEntry));


                    close();
                } catch (Exception e) {
                    // Ignored, we'll let the Form handle the errors
                }


            }
        });

        buttonsLayout.addComponent(changeClientNameButton);

        mainVerticalLayout.addComponent(buttonsLayout);

        addComponent(mainVerticalLayout);


    }


}

