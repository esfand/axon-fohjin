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
public class LedgerRepositoryImpl implements LedgerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings({"unchecked"})
    public List<LedgerEntry> findAllLedgers() {
        return entityManager.createQuery("SELECT e FROM LedgerEntry e")
                .setMaxResults(250)
                .getResultList();
    }

    @Override
    public List<LedgerEntry> findByAccountId(String activeAccountId) {

        return entityManager.createQuery("SELECT e FROM LedgerEntry e WHERE e.activeAccountId = :activeAccountId")
                .setParameter("activeAccountId", activeAccountId)
                .setMaxResults(250)
                .getResultList();

    }
}
