package nijhof2axon.ui.data;

import com.vaadin.data.util.BeanItemContainer;
import nijhof2axon.app.query.ActiveAccountEntry;
import nijhof2axon.app.query.ActiveAccountRepository;
import nijhof2axon.ui.UIEvent;
import nijhof2axon.ui.MediatorListener;
import nijhof2axon.ui.events.ActiveAccountCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
@Component
public class ActiveAccountContainer extends BeanItemContainer<ActiveAccountEntry> implements Serializable, MediatorListener {

    @Autowired
    private ActiveAccountRepository activeAccountRepository;

    public ActiveAccountContainer() throws IllegalArgumentException {
        super(ActiveAccountEntry.class);
    }

    public void refreshContent(String clientIdentifier) {
        List<ActiveAccountEntry> activeAccountEntries = activeAccountRepository.findByClient(clientIdentifier);
        removeAllItems();
        addAll(activeAccountEntries);
    }

    public ActiveAccountEntry refresh(ActiveAccountEntry activeAccountEntry) {
        return activeAccountRepository.findById(activeAccountEntry.getIdentifier());
    }

    @Override
    public void handleEvent(UIEvent event) {
        if (event instanceof ActiveAccountCreatedEvent) {
            refreshContent(((ActiveAccountCreatedEvent) event).getClientIdentifier());
        }
    }
}


