package nijhof2axon.app.domain;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class CreditMutation extends Ledger {
    public CreditMutation(BigDecimal amount, String accountNumber) {
        super(amount, null);
    }
}
