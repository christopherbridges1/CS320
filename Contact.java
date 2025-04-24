//Chris Bridges
// Contact class definition
class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor with validation
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        this.contactId = validateContactId(contactId);
        this.firstName = validateFirstName(firstName);
        this.lastName = validateLastName(lastName);
        this.phone = validatePhone(phone);
        this.address = validateAddress(address);
    }

    // Validation methods
    private String validateContactId(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot be longer than 10 characters");
        }
        return contactId;
    }

    private String validateFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name cannot be longer than 10 characters");
        }
        return firstName;
    }

    private String validateLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name cannot be longer than 10 characters");
        }
        return lastName;
    }

    private String validatePhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        return phone;
    }

    private String validateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (address.length() > 30) {
            throw new IllegalArgumentException("Address cannot be longer than 30 characters");
        }
        return address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = validateFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = validateLastName(lastName);
    }

    public void setPhone(String phone) {
        this.phone = validatePhone(phone);
    }

    public void setAddress(String address) {
        this.address = validateAddress(address);
    }
}
