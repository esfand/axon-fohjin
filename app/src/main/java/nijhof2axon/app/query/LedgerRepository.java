package nijhof2axon.app.query;

import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public interface LedgerRepository {
    List<LedgerEntry> findAllLedgers();

    List<LedgerEntry> findByAccountId(String activeAccountId);
}
