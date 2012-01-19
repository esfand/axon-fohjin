package nijhof2axon.app.query;

import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public interface ClientRepository {
    List<ClientDetailsEntry> findAllClients();

    ClientDetailsEntry findByIdentifier(String identifier);

    void persist(ClientDetailsEntry entry);
}
