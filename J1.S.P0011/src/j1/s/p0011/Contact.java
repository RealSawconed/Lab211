package j1.s.p0011;

import java.util.ArrayList;

/**
 *
 * @author DatDDCE171299
 */
public class Contact implements IContact {

    private int id; // Store contact ID
    private String name; // Store contact Name
    private String group; // Store contact Group
    private String address; // Store contact Address 
    private String phone; // Store contact Phone number
    private static ArrayList<Contact> contactList; // Store list of contact information

    /**
     * Create a default constructor that initialize contact ID and list of
     * contact information
     */
    public Contact() {
        this.id = 0; // Set initial ID to 0
        contactList = new ArrayList<>(); // Initialize list with no available data
    }

    /**
     * Create a constructor with given information
     *
     * @param id
     * @param name
     * @param group
     * @param address
     * @param phone
     */
    public Contact(int id, String name, String group, String address, String phone) {
        this.id = id; // Set ID for contact
        setName(name); // Set name for contact
        setGroup(group); // Set group for contact
        setAddress(address); // Set address for contact
        setPhone(phone); // Set phone number for contact
    }

    /**
     * Get the ID from contact information
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name from contact information
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name for contact information
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the group from contact information
     *
     * @return
     */
    public String getGroup() {
        return group;
    }

    /**
     * Set the group for contact information
     *
     * @param group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Get the address from contact information
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address for contact information
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the phone number for contact information
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the phone for contact information without duplication
     *
     * @param phone
     */
    public void setPhone(String phone) {
        if (checkPhoneExist(phone)) { // Throw when phone is already existed
            throw new IllegalArgumentException("The candidate's phone has already existed!");
        } else {
            this.phone = phone;
        }
    }

    /**
     * Get the size of the contact list
     *
     * @return
     */
    public int getSize() {
        return contactList.size();
    }

    /**
     * Add new contact information to main list
     */
    @Override
    public void addContact() {
        // Automatically increase the ID by 1
        contactList.add(new Contact(++this.id, this.name, this.group, this.address, this.phone));
    }

    /**
     * Return the contact information with given ID
     *
     * @param id
     * @return
     */
    @Override
    public Contact display(int id) {
        return contactList.get(id);
    }

    /**
     * Delete contact information with given ID
     *
     * @param id
     */
    @Override
    public void deleteContact(int id) {
        int index = -1; // Store index found to delete
        for (int i = 0; i < contactList.size(); i++) { // Traverse through the whole list
            Contact c = contactList.get(i); // Store information of current ID
            if (c.getId() == id) { // Stop traversing and assign found index for deletion
                index = i;
                break;
            }
        }
        // Delete required contact information with found index
        contactList.remove(contactList.get(index));
    }

    /**
     * Check if phone has already existed
     *
     * @param phone
     * @return
     */
    public static boolean checkPhoneExist(String phone) {
        for (Contact c : contactList) { // Traverse through main list to find phone number
            if (c.getPhone().equalsIgnoreCase(phone)) { // Return true when similar phone is found
                return true;
            }
        }

        // Return false if no similar phone is found
        return false;
    }

    /**
     * Check if ID has already existed
     *
     * @param id
     * @return
     */
    public static boolean checkIDExist(int id) {
        for (Contact c : contactList) { // Traverse through main list to find ID
            if (c.getId() == id) { // Return true when similar ID is found
                return true;
            }
        }
        // Return false if no similar ID is found
        return false;
    }
}
