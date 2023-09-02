package l01;

/**
 *
 * @author DatDDCE171299
 */
public class Experience extends Candidate {

    private int expInYear; // Store Experience years of experience
    private String proSkill; // Store Experience professional skill

    /**
     * Create a default constructor that inherence Candidate properties
     */
    public Experience() {
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
     * @param expInYear
     * @param proSkill
     */
    public Experience(String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, int expInYear, String proSkill) {
        // Inherence Candidate class properties
        super(id, firstName, lastName, birthDate, address, phone, email, type);
        setExpInYear(expInYear); // Set year of experience for candidate
        setProSkill(proSkill); // Set professional skill for candidate
    }

    /**
     * Create a constructor that inherence Candidate properties and given
     * information
     *
     * @param candidates
     * @param expInYear
     * @param proskill
     */
    public Experience(Candidate candidates, int expInYear, String proskill) {
        // Inherence Candidate class properties with given instance
        super(candidates.getId(), candidates.getFirstName(), candidates.getLastName(), candidates.getBirthDate(), candidates.getAddress(), candidates.getPhone(), candidates.getEmail(), candidates.getType());
        setExpInYear(expInYear); // Set year of experience for candidate
        setProSkill(proskill); // Set professional skill for candidate
    }

    /**
     * Get candidate's year of experience
     *
     * @return
     */
    public int getExpInYear() {
        return expInYear;
    }

    /**
     * Set year of experience for candidate
     *
     * @param expInYear
     */
    public void setExpInYear(int expInYear) {
        Validation.checkYearOfExperience(expInYear, super.getBirthDate()); // Validate candidate's year of experience
        this.expInYear = expInYear;
    }

    /**
     * Get the candidate's professional skill
     *
     * @return
     */
    public String getProSkill() {
        return proSkill;
    }

    /**
     * Set the professional skill for candidate
     *
     * @param proSkill
     */
    public void setProSkill(String proSkill) {
        Validation.checkString(proSkill); // Throw when candidate's professional skill is empty
        this.proSkill = proSkill;
    }

}
