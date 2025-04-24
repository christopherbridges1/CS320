import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Chris Bridges
public class ContactTest {
    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("79134", "Jimmy", "Dean", "7913467890", "485 Banks St");
    }

    // ***** Valid Contact Creation *****
    @Test
    public void testContactIdSetCorrectly() {
        Contact valid = new Contact("94875", "Alice", "Cooper", "9487567890", "404 Side St");
        assertEquals("94875", valid.getContactId());
    }

    @Test
    public void testFirstNameSetCorrectly() {
        Contact valid = new Contact("94875", "Alice", "Cooper", "9487567890", "404 Side St");
        assertEquals("Alice", valid.getFirstName());
    }

    @Test
    public void testLastNameSetCorrectly() {
        Contact valid = new Contact("94875", "Alice", "Cooper", "9487567890", "404 Side St");
        assertEquals("Cooper", valid.getLastName());
    }

    @Test
    public void testPhoneSetCorrectly() {
        Contact valid = new Contact("94875", "Alice", "Cooper", "9487567890", "404 Side St");
        assertEquals("9487567890", valid.getPhone());
    }

    @Test
    public void testAddressSetCorrectly() {
        Contact valid = new Contact("94875", "Alice", "Cooper", "9487567890", "404 Side St");
        assertEquals("404 Side St", valid.getAddress());
    }

    @Test
    public void testValidContactIdMaxLength() {
        Contact valid = new Contact("1234567890", "Amy", "Lee", "1234567890", "123 Ave Rd");
        assertEquals("1234567890", valid.getContactId());
    }

    @Test
    public void testValidFirstNameMaxLength() {
        Contact valid = new Contact("ID1", "Firstname1", "Last", "1234567890", "123 Main St");
        assertEquals("Firstname1", valid.getFirstName());
    }

    @Test
    public void testValidLastNameMaxLength() {
        Contact valid = new Contact("ID2", "First", "Lastname2", "1234567890", "123 Main St");
        assertEquals("Lastname2", valid.getLastName());
    }

    @Test
    public void testValidAddressMaxLength() {
        String address = "123456789012345678901234567890";
        Contact valid = new Contact("ID3", "First", "Last", "1234567890", address);
        assertEquals(address, valid.getAddress());
    }

    @Test
    public void testValidAddressCoversFalseBranch() {
        Contact valid = new Contact("A100", "John", "Smith", "1234567890", "123 Main St");
        assertEquals("123 Main St", valid.getAddress());
    }

    @Test
    public void testValidContactIdPassesValidation() {
        Contact contact = new Contact("C123456789", "Test", "User", "1234567890", "123 Test St");
        assertEquals("C123456789", contact.getContactId());
    }

    @Test
    public void testValidFirstNamePassesValidation() {
        Contact contact = new Contact("C123", "Firstname", "User", "1234567890", "123 Test St");
        assertEquals("Firstname", contact.getFirstName());
    }

    @Test
    public void testValidLastNamePassesValidation() {
        Contact contact = new Contact("C123", "First", "Lastname", "1234567890", "123 Test St");
        assertEquals("Lastname", contact.getLastName());
    }

    @Test
    public void testValidPhonePassesValidation() {
        Contact contact = new Contact("C123", "First", "Last", "1234567890", "123 Test St");
        assertEquals("1234567890", contact.getPhone());
    }

    @Test
    public void testValidAddressPassesValidation() {
        Contact contact = new Contact("C123", "First", "Last", "1234567890", "456 Normal Street");
        assertEquals("456 Normal Street", contact.getAddress());
    }

    @Test
    public void testFirstNameExactlyTenCharactersValid() {
        Contact valid = new Contact("C001", "JohnSmith", "Doe", "1234567890", "456 Main St");
        assertEquals("JohnSmith", valid.getFirstName());
    }

    @Test
    public void testLastNameExactlyTenCharactersValid() {
        Contact valid = new Contact("C002", "John", "Smithers", "1234567890", "456 Main St");
        assertEquals("Smithers", valid.getLastName());
    }

    @Test
    public void testPhoneExactlyTenDigitsValid() {
        Contact valid = new Contact("C003", "Jane", "Doe", "1234567890", "456 Main St");
        assertEquals("1234567890", valid.getPhone());
    }

    @Test
    public void testAddressExactlyThirtyCharactersValid() {
        Contact valid = new Contact("C004", "Jane", "Doe", "1234567890", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", valid.getAddress());
    }

    // ***** Contact ID Validation *****
    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Jimmy", "Dean", "7913467890", "485 Banks St"));
    }

    @Test
    public void testContactIdTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("94875678901", "Jimmy", "Dean", "7913467890", "485 Banks St"));
    }

    // ***** First Name Validation *****
    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", null, "Dean", "7913467890", "485 Banks St"));
    }

    @Test
    public void testFirstNameTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "VeryLongName123", "Dean", "7913467890", "485 Banks St"));
    }

    // ***** Last Name Validation *****
    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", null, "7913467890", "485 Banks St"));
    }

    @Test
    public void testLastNameTooLongThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", "VeryLongLastName123", "7913467890", "485 Banks St"));
    }

    // ***** Phone Number Validation *****
    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", "Dean", null, "485 Banks St"));
    }

    @Test
    public void testPhoneTooShortThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", "Dean", "94875", "485 Banks St"));
    }

    @Test
    public void testPhoneWithLettersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", "Dean", "abcdefghij", "485 Banks St"));
    }

    // ***** Address Validation *****
    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("79134", "Jimmy", "Dean", "7913467890", null));
    }

    @Test
    public void testAddressTooLongThrowsException() {
        String longAddress = "123 This address exceeds the 30 char limit!";
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("79134", "Jimmy", "Dean", "7913467890", longAddress));
    }

    // ***** Setter Tests *****
    @Test
    public void testSetFirstNameSuccessfully() {
        contact.setFirstName("Alice");
        assertEquals("Alice", contact.getFirstName());
    }

    @Test
    public void testSetLastNameSuccessfully() {
        contact.setLastName("Brown");
        assertEquals("Brown", contact.getLastName());
    }

    @Test
    public void testSetPhoneSuccessfully() {
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetAddressSuccessfully() {
        contact.setAddress("789 Pine St");
        assertEquals("789 Pine St", contact.getAddress());
    }

    @Test
    public void testSetFirstNameToTony() {
        contact.setFirstName("Tony");
        assertEquals("Tony", contact.getFirstName());
    }

    @Test
    public void testSetLastNameToDanza() {
        contact.setLastName("Danza");
        assertEquals("Danza", contact.getLastName());
    }

    @Test
    public void testSetPhoneToNewValue() {
        contact.setPhone("4051545846");
        assertEquals("4051545846", contact.getPhone());
    }

    @Test
    public void testSetAddressToNewValue() {
        contact.setAddress("911 Potato St");
        assertEquals("911 Potato St", contact.getAddress());
    }
}
