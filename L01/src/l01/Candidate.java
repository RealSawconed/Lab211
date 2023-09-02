package l01;

/**
 *
 * @author DatDDCE171299
 */
public class Candidate {

    private String id; // Store candidate's ID
    private String firstName; // Store candidate's first name 
    private String lastName; // Store candidate's last name
    private int birthDate; // Store candidate's date of birth
    private String address; // Store candidate's address
    private String phone; // Store candidate's phone
    private String email; // Store candidate's email
    private int type; // Store candidate's type

    /**
     * Create a default constructor
     */
    public Candidate() {

    }

    /**
     * Create a constructor with valid given candidate information
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param type
     */
    public Candidate(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        setId(id); // Set ID for candidate
        setFirstName(firstName); // Set first name for candidate
        setLastName(lastName); // Set last name for candidate
        setBirthDate(birthDate); // Set birthdate for candidate
        setAddress(address); // Set address for candidate
        setPhone(phone); // Set phone for candidate
        setEmail(email); // Set email for candidate
        setType(type); // Set type for candidate
    }

    /**
     * Get the candidate's ID
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID for candidate
     *
     * @param id
     */
    public void setId(String id) {
        Validation.checkId(id); // Validate candidate's ID
        this.id = id;
    }

    /**
     * Get the candidate's first name
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name for candidate
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        Validation.checkString(firstName); // Throw when candidate's first name is empty
        this.firstName = firstName;
    }

    /**
     * Get the candidate's last name
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name for candidate
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        Validation.checkString(lastName); // Throw when candidate's last name is empty
        this.lastName = lastName;
    }

    /**
     * Get the candidate's date of birth
     *
     * @return
     */
    public int getBirthDate() {
        return birthDate;
    }

    /**
     * Set the date of birth for candidate
     *
     * @param birthDate
     */
    public void setBirthDate(int birthDate) {
        Validation.checkBirthDate(birthDate); // Validate candidate's date of birth        
        this.birthDate = birthDate;
    }

    /**
     * Get the candidate's address
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address for candidate
     *
     * @param address
     */
    public void setAddress(String address) {
        Validation.checkString(address); // Throw when candidate's address is empty
        this.address = address;
    }

    /**
     * Get the candidate's phone number
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone number for candidate
     *
     * @param phone
     */
    public void setPhone(String phone) {
        Validation.checkPhone(phone); // Validate candidate's phone number
        this.phone = phone;
    }

    /**
     * Get the candidate's email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email for candidate
     *
     * @param email
     */
    public void setEmail(String email) {
        Validation.checkEmail(email); // Validate candidate's email                            
        this.email = email;
    }

    /**
     * Get candidate's type
     *
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * Set type for candidate
     *
     * @param type
     */
    public void setType(int type) {
        Validation.checkRange(type, 0, 2); // Validate candidate's type
        this.type = type;
    }
}
