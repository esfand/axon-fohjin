package nijhof2axon.ui.events;

import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ChangeClientNameRequestedEvent implements UIEvent {
    private ClientDetailsEntry clientDetailsEntry;

    public ChangeClientNameRequestedEvent(ClientDetailsEntry clientDetailsEntry) {
        this.clientDetailsEntry = clientDetailsEntry;
    }

    public ClientDetailsEntry getClientDetailsEntry() {
        return clientDetailsEntry;
    }
}
