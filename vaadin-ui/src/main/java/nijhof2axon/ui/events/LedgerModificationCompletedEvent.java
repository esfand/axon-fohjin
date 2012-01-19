package nijhof2axon.ui.events;

import nijhof2axon.ui.UIEvent;
import nijhof2axon.app.query.ActiveAccountEntry;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class LedgerModificationCompletedEvent implements UIEvent {

    private ActiveAccountEntry activeAccountEntry;

    public LedgerModificationCompletedEvent(ActiveAccountEntry activeAccountEntry) {
        this.activeAccountEntry = activeAccountEntry;
    }

    public ActiveAccountEntry getActiveAccountEntry() {
        return activeAccountEntry;
    }
}
