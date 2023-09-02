package l01;

/**
 *
 * @author DatDDCE171299
 */
public class Fresher extends Candidate {

    private int graduateDate; // Store Fresher graduate date
    private String graduationRank; // Store Fresher graduate rank
    private String education; // Store Fresher education

    /**
     * Create a default constructor with Candidate class properties
     */
    public Fresher() {
        super();
    }

    /**
     * Create a constructor that inherence Candidate properties and given
     * information
     *
     * @param graduateDate
     * @param graduationRank
     * @param education
     * @param id
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param phone
     * @param email
     * @param type
     */
    public Fresher(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, int graduateDate, String graduationRank, String education) {
        // Inherence Candidate class properties
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        setGraduateDate(graduateDate); // Set graduate date for candidate
        setGraduationRank(graduationRank); // Set graduate rank for candidate
        setEducation(education); // Set education place for candidate
    }

    /**
     * Create a constructor that inherence Candidate properties and given
     * information
     *
     * @param candidates
     * @param graduateDate
     * @param graduationRank
     * @param education
     */
    public Fresher(Candidate candidates, int graduateDate, String graduationRank, String education) {
        // Inherence Candidate class properties with given instance
        super(candidates.getId(), candidates.getFirstName(), candidates.getLastName(), candidates.getBirthDate(), candidates.getAddress(), candidates.getPhone(), candidates.getEmail(), candidates.getType());
        setGraduateDate(graduateDate); // Set graduate date for candidate
        setGraduationRank(graduationRank); // Set graduate rank for candidate
        setEducation(education); // Set education place for candidate
    }

    /**
     * Get candidate's graduated time
     *
     * @return
     */
    public int getGraduateDate() {
        return graduateDate;
    }

    /**
     * Set the graduated time for candidate
     *
     * @param graduateDate
     */
    public void setGraduateDate(int graduateDate) {
        Validation.checkGraduationDate(super.getBirthDate(), graduateDate); // Validate candidate's graduation rank
        this.graduateDate = graduateDate;
    }

    /**
     * Get the candidate's graduation rank
     *
     * @return
     */
    public String getGraduationRank() {
        return graduationRank;
    }

    /**
     * Set the graduation rank for candidate
     *
     * @param graduationRank
     */
    public void setGraduationRank(String graduationRank) {
        Validation.checkRank(graduationRank); // Validate candidate's rank of graduation
        this.graduationRank = graduationRank;
    }

    /**
     * Get the candidate's place of education
     *
     * @return
     */
    public String getEducation() {
        return education;
    }

    /**
     * Set the place of education for candidate
     *
     * @param education
     */
    public void setEducation(String education) {
        Validation.checkString(education); // Throw when candidate's place of education is empty            
        this.education = education;
    }

}
