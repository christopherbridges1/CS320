import java.util.HashMap;
import java.util.Map;

//Chris Bridges

public class ContactService {
    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    // Adds a new contact if unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Deletes a contact by ID
    public void deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.remove(contactId);
    }

    // Updates contact fields if the contact exists
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = getValidatedContact(contactId);

        if (firstName != null) contact.setFirstName(firstName);
        if (lastName != null) contact.setLastName(lastName);
        if (phone != null) contact.setPhone(phone);
        if (address != null) contact.setAddress(address);
    }

    // Retrieves a contact for testing 
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // Ensures contact exists before updating or deleting
    private Contact getValidatedContact(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        return contact;
    }
}
