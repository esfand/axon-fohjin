package nijhof2axon.ui.data;

import com.vaadin.data.util.BeanItemContainer;
import nijhof2axon.app.query.LedgerEntry;
import nijhof2axon.app.query.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
@Component
public class LedgerContainer extends BeanItemContainer<LedgerEntry> implements Serializable {

    @Autowired
    private LedgerRepository ledgerRepository;

    public LedgerContainer() throws IllegalArgumentException {
        super(LedgerEntry.class);
    }

    public void refreshContent(String activeAccountId) {
        List<LedgerEntry> allLedgers = ledgerRepository.findByAccountId(activeAccountId);
        removeAllItems();
        addAll(allLedgers);
    }


}


