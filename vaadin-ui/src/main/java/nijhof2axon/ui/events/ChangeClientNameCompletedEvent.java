package nijhof2axon.ui.events;

import nijhof2axon.app.query.ClientDetailsEntry;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ChangeClientNameCompletedEvent implements UIEvent {
    private ClientDetailsEntry clientEntry;

    public ChangeClientNameCompletedEvent(ClientDetailsEntry clientEntry) {
        this.clientEntry = clientEntry;
    }

    public ClientDetailsEntry getClientEntry() {
        return clientEntry;
    }
}
