package nijhof2axon.ui.events;

import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientSelectedEvent implements UIEvent {
    private ClientDetailsEntry selectedClient;

    public ClientSelectedEvent(ClientDetailsEntry clientEntry) {
        this.selectedClient = clientEntry;
    }

    public ClientDetailsEntry getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(ClientDetailsEntry selectedClient) {
        this.selectedClient = selectedClient;
    }
}
