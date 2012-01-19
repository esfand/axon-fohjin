package nijhof2axon.app.query;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
@Entity
public class LedgerEntry {

    LedgerEntry() {
    }

    public LedgerEntry(String activeAccountId, BigDecimal amount, String action) {
        this.activeAccountId = activeAccountId;
        this.amount = amount;
        this.action = action;
    }

    @Id
    @GeneratedValue
    private Long db_identifier;

    @Basic
    private String activeAccountId;

    @Basic
    private BigDecimal amount;

    @Basic
    public String action;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActiveAccountId() {
        return activeAccountId;
    }

    public void setActiveAccountId(String activeAccountId) {
        this.activeAccountId = activeAccountId;
    }
}
