package l01;

/**
 *
 * @author DatDDCE171299
 */
public class Intern extends Candidate {

    private String major; // Store Intern major
    private String semester; // Store Intern semester
    private String universityName; // Store Intern university name

    /**
     * Create a default constructor with Candidate class properties
     */
    public Intern() {
        super();
    }

    /**
     * Create a constructor that inherence Candidate properties and given
     * information
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param type
     * @param major
     * @param semester
     * @param universityName
     */
    public Intern(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, String major, String semester, String universityName) {
        super(id, firstName, lastName, birthDate, address, phone, email, type); // Inherence Candidate properties
        setMajor(major); // Set major for candidate
        setSemester(semester); // Set semester for candidate
        setUniversityName(universityName); // Set university name for candidate
    }

    /**
     * Create a constructor that inherence Candidate properties and given
     * information
     *
     * @param candidates
     * @param major
     * @param semester
     * @param universityName
     */
    public Intern(Candidate candidates, String major, String semester, String universityName) {
        // Inherence Candidate properties with given instance
        super(candidates.getId(), candidates.getFirstName(), candidates.getLastName(), candidates.getBirthDate(), candidates.getAddress(), candidates.getPhone(), candidates.getEmail(), candidates.getType());
        setMajor(major); // Set major for candidate
        setSemester(semester); // Set semester for candidate
        setUniversityName(universityName); // Set university name for candidate
    }

    /**
     * Get candidate's major
     *
     * @return
     */
    public String getMajor() {
        return major;
    }

    /**
     * Set the major for candidate
     *
     * @param major
     */
    public void setMajor(String major) {
        Validation.checkString(major); // Throw when candidate's major is empty

        this.major = major;
    }

    /**
     * Get the candidate's semester
     *
     * @return
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Set the semester for candidate
     *
     * @param semester
     */
    public void setSemester(String semester) {
        Validation.checkString(semester); // Throw when candidate's semester is empty
        this.semester = semester;
    }

    /**
     * Get candidate's university name
     *
     * @return
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Set the university name for candidate
     *
     * @param universityName
     */
    public void setUniversityName(String universityName) {
        Validation.checkString(universityName); // Throw when candidate's university name is empty
        this.universityName = universityName;
    }

}
