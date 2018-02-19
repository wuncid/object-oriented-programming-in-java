/**
 * A bank account that has a balance and an account number.
 */
public class BankAccount {
    private String account;
    private double balance;

    /**
     * Constructs a bank account with a default account number of 12345
     * and an initial balance of 500.
     */
    public BankAccount() {
        account = "12345";
        balance = 500;
    }

    /**
     * Sets the account number of the account.
     *
     * @param accountNumber the account number to set
     */
    public void setAccount(String accountNumber) {
        this.account = accountNumber;
    }

    /**
     * Sets the balance of the account.
     *
     * @param newBalance the balance to set
     */
    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    /**
     * Gets the balance of the account.
     *
     * @return the account number
     */
    public String getAccount() {
        return account;
    }

    /**
     * Gets the balance of the account.
     *
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }
}
