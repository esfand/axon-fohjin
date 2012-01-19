package nijhof2axon.app.command;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class OpenNewAccountForClientCommand {

    private String accountId;
    private String clientId;
    private String accountName;
    private String accountNumber;

    public OpenNewAccountForClientCommand(String clientId, String accountName, String accountNumber) {
        this(null, clientId, accountName, accountNumber);
    }

    public OpenNewAccountForClientCommand(String accountId, String clientId, String accountName, String accountNumber) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}