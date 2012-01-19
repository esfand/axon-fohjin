package nijhof2axon.ui.client;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.events.*;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientDetailsForm extends MediatorVerticalLayout implements MediatorListener {

    private ClientDetailsEntry clientDetailsEntry;
    private Label clientLabel;
    private Label streetLabel;
    private Label streetNumber;
    private Label postalCode;
    private Label city;
    private Label phoneNumber;

    public ClientDetailsForm() {

        addMenuItems();

        VerticalLayout mainVerticalLayout = new VerticalLayout();
        mainVerticalLayout.setSpacing(true);

        HorizontalLayout space = new HorizontalLayout();
        space.setHeight("40%");
        mainVerticalLayout.addComponent(space);

        clientLabel = addLabel(mainVerticalLayout, "Name: ");
        streetLabel = addLabel(mainVerticalLayout, "Street: ");
        streetNumber = addLabel(mainVerticalLayout, "Street Number: ");
        postalCode = addLabel(mainVerticalLayout, "Postal Code: ");
        city = addLabel(mainVerticalLayout, "City: ");
        phoneNumber = addLabel(mainVerticalLayout, "Phone Number: ");

        Button backButton = new Button("Back");
        backButton.addListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                fire(new ClientListViewRequestedEvent());
            }
        });

        mainVerticalLayout.addComponent(backButton);

        addComponent(mainVerticalLayout);

    }

    private void addMenuItems() {
        MenuBar menuBar = new MenuBar();

        MenuBar.MenuItem menuItemClient = menuBar.addItem("Client", null);

        menuItemClient.addItem("Change name", new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                fire(new ChangeClientNameRequestedEvent(clientDetailsEntry));
            }
        });

        menuItemClient.addItem("Open Active Account", new MenuBar.Command() {
            public void menuSelected(MenuBar.MenuItem selectedItem) {
                fire(new AddActiveAccountRequestedEvent(clientDetailsEntry));
            }
        });

        addComponent(menuBar);
    }

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

    public void refreshFor(ClientDetailsEntry clientEntry) {
        this.clientDetailsEntry = clientEntry;

        BeanItem item = new BeanItem(clientEntry);
        item.removeItemProperty("identifier");

        clientLabel.setValue(clientEntry.getClientName());
        streetLabel.setValue(clientEntry.getStreet());
        streetNumber.setValue(clientEntry.getStreetNumber());
        postalCode.setValue(clientEntry.getPostalCode());
        city.setValue(clientEntry.getCity());
        phoneNumber.setValue(clientEntry.getPhoneNumber());


    }

    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ClientSelectedEvent) {
            refreshFor(((ClientSelectedEvent) event).getSelectedClient());
        }

        if (event instanceof ChangeClientNameCompletedEvent) {
            refreshFor(((ChangeClientNameCompletedEvent) event).getClientEntry());
        }

        if (event instanceof ActiveAccountCreatedEvent) {
            getApplication().getMainWindow().showNotification("Account Opened Successfully", Window.Notification.TYPE_HUMANIZED_MESSAGE);
        }

    }


}
