package nijhof2axon.ui.events;

import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.ui.UIEvent;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class CashWithdrawalRequestedEvent implements UIEvent {

    private ActiveAccountEntry activeAccountEntry;

    public CashWithdrawalRequestedEvent(ActiveAccountEntry activeAccountEntry) {
        this.activeAccountEntry = activeAccountEntry;
    }

    public ActiveAccountEntry getActiveAccountEntry() {
        return activeAccountEntry;
    }

}
