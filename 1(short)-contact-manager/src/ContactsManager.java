/**
 * A contact manager for managing contacts. Includes methods the add contact
 * and search  for contacts.
 */
public class ContactsManager {
    Contact [] myFriends;
    int friendsCount;

    /**
     * Constructs a Contact manager.
     */
    ContactsManager(){
        friendsCount = 0;
        myFriends = new Contact[500];
    }

    /**
     * Adds a contact.
     *
     * @param contact the contact to add
     */
    void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    /**
     * Search for a contact.
     *
     * @param searchName the name of the contact to search for
     * @return the contact with that name, null if contact with that name was not found
     */
    Contact searchContact(String searchName){
        for(int i = 0; i < friendsCount; i++){
            if(myFriends[i].name.equals(searchName)){
                return myFriends[i];
            }
        }
        return null;
    }
}
