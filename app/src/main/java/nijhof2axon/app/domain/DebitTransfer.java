package nijhof2axon.app.domain;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class DebitTransfer extends Ledger {
    public DebitTransfer(BigDecimal amount, String accountNumber) {
        super(amount, accountNumber);
    }
}
