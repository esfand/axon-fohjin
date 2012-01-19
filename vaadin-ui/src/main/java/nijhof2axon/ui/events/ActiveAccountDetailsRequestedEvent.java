package nijhof2axon.ui.events;

import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class ActiveAccountDetailsRequestedEvent implements UIEvent {

    private ActiveAccountEntry activeAccountEntry;

    public ActiveAccountDetailsRequestedEvent(ActiveAccountEntry activeAccountEntry) {
        this.activeAccountEntry = activeAccountEntry;
    }

    public ActiveAccountEntry getActiveAccountEntry() {
        return activeAccountEntry;
    }
}
