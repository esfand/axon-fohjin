package nijhof2axon.app.query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
@Repository
@Transactional(readOnly = true)
public class ClientRepositoryImpl implements ClientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings({"unchecked"})
    public List<ClientDetailsEntry> findAllClients() {
        return entityManager.createQuery("SELECT e FROM ClientDetailsEntry e")
                .setMaxResults(250)
                .getResultList();
    }

    @Override
    public ClientDetailsEntry findByIdentifier(String identifier) {
        return (ClientDetailsEntry) entityManager.createQuery("SELECT e FROM ClientDetailsEntry e WHERE e.identifier=:identifier")
                .setParameter("identifier", identifier)
                .getSingleResult();
    }

    @Override
    public void persist(ClientDetailsEntry entry) {
        entityManager.persist(entry);
    }


}

