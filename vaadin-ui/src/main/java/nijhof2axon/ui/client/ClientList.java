package nijhof2axon.ui.client;

import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.Table;
import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.Nijhof2AxonApplication;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.MediatorVerticalLayout;
import nijhof2axon.ui.data.ClientContainer;
import nijhof2axon.ui.events.ChangeClientNameCompletedEvent;
import nijhof2axon.ui.events.ClientSelectedEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientList extends MediatorVerticalLayout implements MediatorListener {

    public ClientList() {

        final Table clientsTable = new Table("Clients");
        clientsTable.setContainerDataSource(Nijhof2AxonApplication.clientContainer);

        clientsTable.setVisibleColumns(new String[]{"clientName", "city", "street", "streetNumber", "postalCode", "phoneNumber"});

        clientsTable.setColumnHeader("clientName", "Name");
        clientsTable.setColumnHeader("city", "City");
        clientsTable.setColumnHeader("street", "Street");
        clientsTable.setColumnHeader("streetNumber", "Street Number");
        clientsTable.setColumnHeader("postalCode", "Postal Code");
        clientsTable.setColumnHeader("phoneNumber", "Phone Number");

        clientsTable.addListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {

                BeanItem beanItem = (BeanItem) event.getItem();

                ClientDetailsEntry clientEntry = (ClientDetailsEntry) beanItem.getBean();

                fire(new ClientSelectedEvent(clientEntry));

            }
        });

        Nijhof2AxonApplication.clientContainer.refreshContent();

        addComponent(clientsTable);
    }


    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ChangeClientNameCompletedEvent) {
            Nijhof2AxonApplication.clientContainer.refreshContent();
        }

    }
}
