package j1.s.p0012;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author DatDDCE171299
 */
public class DoctorHash implements IDoctor {

    private String code; // Store doctor's code
    private String name; // Store doctor's name
    private String specialization; // Store doctor's specialization
    private int availability; // Store doctor's availability
    private static Hashtable<String, DoctorHash> doctorList; // Store list of doctor's data

    /**
     * Create a default constructor and initialize list of doctor's data
     */
    public DoctorHash() {
        doctorList = new Hashtable<>();
    }

    /**
     * Create a constructor with given doctor's information
     *
     * @param code
     * @param name
     * @param specialization
     * @param availability
     */
    public DoctorHash(String code, String name, String specialization, int availability) {
        setCode(code); // Set code for doctor
        setName(name); // Set name for doctor
        setSpecialization(specialization); // Set specialization for doctor
        setAvailability(availability); // Set availability for doctor
    }

    /**
     * Create a constructor with given doctor's information other than code
     *
     * @param name
     * @param specialization
     * @param availability
     */
    public DoctorHash(String name, String specialization, int availability) {
        setName(name); // Set name for doctor
        setSpecialization(specialization); // Set specialization for doctor
        setAvailability(availability); // Set availability for doctor
    }

    /**
     * Get the code from doctor
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the code for doctor
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get name from doctor
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set name for doctor
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the specialization from doctor
     *
     * @return
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set the specialization for doctor
     *
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Get the availability from doctor
     *
     * @return
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Set the availability for doctor
     *
     * @param availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Get doctor's data list size
     *
     * @return
     */
    public int getSize() {
        return doctorList.size();
    }

    /**
     * Get the data from doctor's data list
     *
     * @return
     */
    public static Hashtable<String, DoctorHash> getDoctorList() {
        return doctorList;
    }

    /**
     * Add new doctor's data to list
     */
    @Override
    public void add() {
        doctorList.put(this.code, new DoctorHash(this.name, this.specialization, this.availability));
    }

    /**
     * Update current doctor's data with given code
     */
    @Override
    public void update() {
        DoctorHash d = doctorList.get(this.code);
        if (this.name.equals("")) { // Make no change when user input blank name
            this.name = d.getName();
        }
        if (this.specialization.equals("")) { // Make no change when user input blank specialization
            this.specialization = d.getSpecialization();
        }
        if (this.availability == -1) { // Make no chance when user input blank availability
            this.availability = d.getAvailability();
        }

        // Update current doctor's data
        doctorList.put(this.code, new DoctorHash(this.name, this.specialization, this.availability));
    }

    /**
     * Delete current doctor's data with given code
     */
    @Override
    public void delete() {
        doctorList.remove(this.code);
    }

    /**
     * Search doctor's data with given information text
     *
     * @param str
     * @return
     */
    @Override
    public Hashtable<String, DoctorHash> search(String str) {
        // Create a new list that store suitable doctor's data
        Hashtable<String, DoctorHash> foundList = new Hashtable<>();

        Enumeration<String> e = doctorList.keys(); // Traverse through the whole main list
        while (e.hasMoreElements()) { // Loop until no more element left
            String key = e.nextElement(); // Store the key of current element
            DoctorHash d = doctorList.get(key); // Store the value of current element
            String strNum = "" + d.getAvailability(); // Change availablility value to string for comparison

            // Add current element to new list if suitable data is found in doctor information
            if (d.getName().toLowerCase().contains(str.toLowerCase())
                    || d.getSpecialization().toLowerCase().contains(str.toLowerCase())
                    || strNum.equals(str)) {
                foundList.put(key, d);
            }
        }

        // Return the list of every found data
        return foundList;
    }

    /**
     * Check if the input code is already existed
     *
     * @param code
     * @return
     */
    public static boolean checkCodeExist(String code) {
        Enumeration<String> e = doctorList.keys(); // Traverse through the whole list

        // Loop until no more element left
        while (e.hasMoreElements()) {
            String key = e.nextElement(); // Store the key of the current element
            if (key.equals(code)) { // Check existed code
                return true;
            }
        }
        // Return when no code is found available in list
        return false;
    }
}
