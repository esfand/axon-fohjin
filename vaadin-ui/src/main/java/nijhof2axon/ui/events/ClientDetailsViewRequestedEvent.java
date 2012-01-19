package nijhof2axon.ui.events;

import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.UIEvent;

/**
 * User: Bahadir Konu (bah.konu@gmail.com)
 */
public class ClientDetailsViewRequestedEvent implements UIEvent {
    private ClientDetailsEntry clientEntry;

    public ClientDetailsViewRequestedEvent(ClientDetailsEntry clientEntry) {
        this.clientEntry = clientEntry;
    }

    public ClientDetailsEntry getClientEntry() {
        return clientEntry;
    }

    public void setClientEntry(ClientDetailsEntry clientEntry) {
        this.clientEntry = clientEntry;
    }
}
