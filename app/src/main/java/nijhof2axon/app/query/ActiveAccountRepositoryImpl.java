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
public class ActiveAccountRepositoryImpl implements ActiveAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ActiveAccountEntry> findAll() {

        return entityManager.createQuery("SELECT e FROM ActiveAccountEntry e")
                .setMaxResults(250)
                .getResultList();

    }

    @Override
    public List<ActiveAccountEntry> findByClient(String clientIdentifier) {

        return entityManager.createQuery("SELECT e FROM ActiveAccountEntry e WHERE e.clientIdentifier = :clientIdentifier")
                .setParameter("clientIdentifier", clientIdentifier)
                .setMaxResults(250)
                .getResultList();
    }

    @Override
    public void save(ActiveAccountEntry activeAccountEntry) {
        entityManager.persist(activeAccountEntry);
    }

    @Override
    public ActiveAccountEntry findById(String identifier) {
        return (ActiveAccountEntry) entityManager.createQuery("SELECT e FROM ActiveAccountEntry e WHERE e.identifier = :identifier")
                .setParameter("identifier", identifier)
                .getSingleResult();
    }
}
