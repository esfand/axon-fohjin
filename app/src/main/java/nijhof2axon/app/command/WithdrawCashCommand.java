package nijhof2axon.app.command;

import java.math.BigDecimal;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com) 
 */
public class WithdrawCashCommand {

    private String activeAccountId;
    private BigDecimal amount;

    public WithdrawCashCommand(String activeAccountId, BigDecimal amount) {
        this.activeAccountId = activeAccountId;
        this.amount = amount;
    }

    public String getActiveAccountId() {
        return activeAccountId;
    }

    public void setActiveAccountId(String activeAccountId) {
        this.activeAccountId = activeAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
