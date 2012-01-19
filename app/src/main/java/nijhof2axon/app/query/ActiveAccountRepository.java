package nijhof2axon.app.query;

import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public interface ActiveAccountRepository {

    List<ActiveAccountEntry> findAll();
    List<ActiveAccountEntry> findByClient(String clientIdentifier);
    void save(ActiveAccountEntry activeAccountEntry);
    ActiveAccountEntry findById(String id);

}
