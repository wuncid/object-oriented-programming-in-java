// create the ContactsManager program
// in the main method write the following:

// Create a ContactsManager object called myContactsManager using the default constructor
// Create a new Contact variable
// Set the name to a friend's name
// Set the phoneNumber field to their phone number
// Call the addContact method in myContactsManager to add that contact
// Repeat steps 2 and 3 for 4 more contacts
// Search for a contact using the method searchContact and print out their phone number

/**
 * A contact manager tester.
 */
public class Main {
    public static void main(String [] args){
        ContactsManager myContactsManager = new ContactsManager();

        Contact friend1 = new Contact();
        friend1.name = "Klaudia";
        friend1.phoneNumber = "570574856";
        myContactsManager.addContact(friend1);

        Contact friend2 = new Contact();
        friend1.name = "Amor";
        friend1.phoneNumber = "000";
        myContactsManager.addContact(friend2);

        System.out.println(myContactsManager.searchContact("Amor").phoneNumber);
    }
}
