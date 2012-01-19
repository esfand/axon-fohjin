package nijhof2axon.app.domain;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class DebitMutation extends Ledger {
    public DebitMutation(BigDecimal amount, String accountNumber) {
        super(amount, null);
    }
}
