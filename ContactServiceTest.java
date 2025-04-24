import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// chris bridges
public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
        contact = new Contact("97451", "Jimmy", "Dean", "9745167890", "123 Main St");
        contactService.addContact(contact);
    }

    // ***** Add Contact Tests *****
    @Test
    public void testAddContactSuccessfully() {
        Contact newContact = new Contact("add001", "Alice", "Smith", "1234567890", "456 Elm St");
        contactService.addContact(newContact);
        assertEquals(newContact, contactService.getContact("add001"));
    }

    @Test
    public void testAddDuplicateContactThrowsException() {
        Contact duplicateContact = new Contact("97451", "John", "Doe", "9876543210", "789 Oak St");
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(duplicateContact));
    }

    @Test
    public void testAddNullContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(null));
    }

    @Test
    public void testAddContactNotNullCoversFalseBranch() {
        Contact contact = new Contact("green001", "First", "Last", "1234567890", "Green St");
        assertDoesNotThrow(() -> contactService.addContact(contact));
    }

    // ***** Delete Contact Tests *****
    @Test
    public void testDeleteContactSuccessfully() {
        contactService.deleteContact("97451");
        assertNull(contactService.getContact("97451"));
    }

    @Test
    public void testDeleteNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact("99999"));
    }

    @Test
    public void testDeleteNullContactIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> contactService.deleteContact(null));
    }

    @Test
    public void testDeleteContactValidIdCoversFalseBranch() {
        Contact contact = new Contact("green002", "Delete", "Me", "1234567890", "Del St");
        contactService.addContact(contact);
        assertDoesNotThrow(() -> contactService.deleteContact("green002"));
    }

    // ***** Update Contact *****
    @Test
    public void testUpdateContactFirstNameSuccessfully() {
        contactService.updateContact("97451", "Tony", null, null, null);
        assertEquals("Tony", contactService.getContact("97451").getFirstName());
    }

    @Test
    public void testUpdateContactLastNameSuccessfully() {
        contactService.updateContact("97451", null, "Stark", null, null);
        assertEquals("Stark", contactService.getContact("97451").getLastName());
    }

    @Test
    public void testUpdateContactPhoneSuccessfully() {
        contactService.updateContact("97451", null, null, "0987654321", null);
        assertEquals("0987654321", contactService.getContact("97451").getPhone());
    }

    @Test
    public void testUpdateContactAddressSuccessfully() {
        contactService.updateContact("97451", null, null, null, "789 Baker St");
        assertEquals("789 Baker St", contactService.getContact("97451").getAddress());
    }

    @Test
    public void testUpdateNonExistentContactThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateContact("99999", "Tony", "Stark", "0987654321", "789 Baker St"));
    }

    // ***** Update Contact *****
    @Test
    public void testUpdateContactInvalidFirstNameThrowsException() {
        contactService.addContact(new Contact("red001", "John", "Doe", "1234567890", "123 St"));
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateContact("red001", "ThisNameIsWayTooLong", null, null, null));
    }

    @Test
    public void testUpdateContactInvalidLastNameThrowsException() {
        contactService.addContact(new Contact("red002", "Jane", "Doe", "1234567890", "123 St"));
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateContact("red002", null, "ThisLastNameIsWayTooLong", null, null));
    }

    @Test
    public void testUpdateContactInvalidPhoneThrowsException() {
        contactService.addContact(new Contact("red003", "Rick", "James", "1234567890", "123 St"));
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateContact("red003", null, null, "invalidPhone", null));
    }

    @Test
    public void testUpdateContactInvalidAddressThrowsException() {
        contactService.addContact(new Contact("red004", "Tony", "Hawk", "1234567890", "123 St"));
        assertThrows(IllegalArgumentException.class, () ->
            contactService.updateContact("red004", null, null, null,
                "This address is way too long for the requirement."));
    }

    // ***** Update Individual Fields Tests *****
    @Test
    public void testUpdateOnlyFirstName() {
        contactService.updateContact("97451", "Peter", null, null, null);
        assertEquals("Peter", contactService.getContact("97451").getFirstName());
    }

    @Test
    public void testUpdateOnlyLastName() {
        contactService.updateContact("97451", null, "Parker", null, null);
        assertEquals("Parker", contactService.getContact("97451").getLastName());
    }

    @Test
    public void testUpdateOnlyPhone() {
        contactService.updateContact("97451", null, null, "1234567890", null);
        assertEquals("1234567890", contactService.getContact("97451").getPhone());
    }

    @Test
    public void testUpdateOnlyAddress() {
        contactService.updateContact("97451", null, null, null, "123 Spider St");
        assertEquals("123 Spider St", contactService.getContact("97451").getAddress());
    }
}
