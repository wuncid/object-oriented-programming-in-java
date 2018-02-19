/**
 * A bank account with an extra limit field.
 */
public class CheckingAccount extends BankAccount {
    double limit;

    /**
     * Sets the limit of the account.
     *
     * @param newLimit the limit to set
     */
    public void setLimit(double newLimit) {
        this.limit = newLimit;
    }

    /**
     * Gets the limit of the account.
     *
     * @return the limit
     */
    public double getLimit() {
        return limit;
    }
}
