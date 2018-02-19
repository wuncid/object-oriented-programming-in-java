// Now it's your turn, open IntelliJ and start a new project called BankManager
// that will contain the following classes:
//      CheckingAccount
//      SavingsAccount
//      CertificateOfDeposit
// Make sure they all extend from the same class called BankAccount that includes
// all the common fields.

// Don't worry about implementing any of the methods for now, just leave them
// all blank. This exercise is mainly focusing on designing the code rather
// than writing any logic code.

// Create a new class called BankAccount with account and balance fields
// Create a new class called CheckingAccount that externds BankAccount with an
// extra limit field.
// Repeat the same for SavingsAccount and COD
// In the main method, create an instance of each of the child classes
// Make sure you can access the account and balance fields (set them and read them)

/**
 * A bank manager tester.
 */
public class Main {
    public static void main(String [] args) {
        BankAccount account1 = new BankAccount();
        account1.setAccount("1");
        account1.setBalance(1000);
        System.out.println(account1.getAccount());
        System.out.println(account1.getBalance());

        CheckingAccount account2 = new CheckingAccount();
        account2.setAccount("2");
        account2.setBalance(1500);
        account2.setLimit(2000);
        System.out.println(account2.getAccount());
        System.out.println(account2.getBalance());
        System.out.println(account2.getLimit());

        SavingsAccount account3 = new SavingsAccount();
        account3.setAccount("3");
        account3.setBalance(2500);
        System.out.println(account3.getAccount());
        System.out.println(account3.getBalance());
    }
}
