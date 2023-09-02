package l01;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class Management {

    private static ArrayList<Candidate> candidate; // Create a list to store candidate data

    /**
     * Create a default constructor that initialize the candidate data list
     */
    public Management() {
        candidate = new ArrayList<>(); // Initialize candidate data
    }

    /**
     * Create new candidate
     *
     * @param candidateType
     */
    public void createCandidate(int type) {

        String id, firstName, lastName, address, phone, email;
        int birthDate;
        boolean loop = true; // Check looping condition
        Scanner userInput = new Scanner(System.in); // Create an objet from Scanner class

        // Loop until it is broken
        while (loop) {

            /*Input candidate's ID*/
            do { // Make sure inputted ID is valid
                try {
                    System.out.print("- Please enter candidate's ID (CDxxxx): ");
                    // Input and validate ID
                    id = Validation.checkId(userInput.nextLine().trim());
                    // Check ID existance
                    checkIdExist(id);
                    break;
                } catch (IllegalArgumentException iae) { // Throw when ID is not in given syntax
                    System.out.println(iae.getMessage());// or has already existed
                }
            } while (true);

            /*Input candidate's first name*/
            do { // Make sure inputted first name is valid
                try {
                    System.out.print("- Please enter candidate's first name: ");
                    // Input and validate first name
                    firstName = Validation.checkString(userInput.nextLine().trim());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when first name is empty
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Input candidate's last name*/
            do { // Make sure inputted last name is valid
                try {
                    System.out.print("- Please enter candidate's last name: ");
                    // Input and validate last name
                    lastName = Validation.checkString(userInput.nextLine().trim());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when last name is empty
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Input candidate's birthdate*/
            do { // Make sure inputted birthdate is valid
                try {
                    System.out.print("- Please enter candidate's birthdate: ");
                    // Input and validate birthdate
                    birthDate = Validation.checkBirthDate(userInput.nextInt());
                    userInput.nextLine();
                    break;
                } catch (IllegalArgumentException iae) { // Throw when birthdate is out of range
                    System.out.println(iae.getMessage());
                } catch (Exception e) { // Throw when value is non-numerical
                    int currentYear = Year.now().getValue(); // Get the current year for comparison
                    System.out.println("The candidate's birthdate must be an integer from 1900 to " + currentYear + "!");
                    userInput.nextLine();
                }
            } while (true);

            /*Input candidate's address*/
            do { // Make sure inputted address is valid
                try {
                    System.out.print("- Please enter candidate's address: ");
                    // Input and validate address
                    address = Validation.checkString(userInput.nextLine().trim());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when address is empty
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Input candidate's phone number*/
            do { // Make sure inputted phone number is valid
                try {
                    System.out.print("- Please enter candidate's phone: ");
                    // Input and validate phone number
                    phone = Validation.checkPhone(userInput.nextLine().trim());
                    // Check phone number existance
                    checkPhoneExist(phone);
                    break;
                } catch (IllegalArgumentException iae) { // Throw when phone number is not in given syntax
                    System.out.println(iae.getMessage());// or has already existed
                }
            } while (true);

            /*Input candidate's email*/
            do { // Make sure inputted email is valid
                try {
                    System.out.print("- Please enter candidate's email: ");
                    // Input and validate email
                    email = Validation.checkEmail(userInput.nextLine().trim());
                    // Check email existance
                    checkEmailExist(email);
                    break;
                } catch (IllegalArgumentException iae) { // Throw when email input is not in given syntax
                    System.out.println(iae.getMessage());// or has alreay existed
                }
            } while (true);

            // Create a new instance of candidate class to store candidate's general data
            Candidate candidates = new Candidate(id, formatString(firstName), formatString(lastName), birthDate, formatString(address), phone, email, type);

            // Creating new candidata data with given type properties
            switch (type) {
                case 0: // Create Experience candidate data
                    createExperience(candidates);
                    break;

                case 1: // Create Fresher candidate data
                    createFresher(candidates);
                    break;

                case 2: // Create Intern candidate data
                    createIntern(candidates);
                    break;
            }

            boolean newCandidate; // Check looping condition
            do { // make sure user input is valid
                try {
                    System.out.print("\nDo you want to order now (Y/N)? ");
                    // Input and validate looping input
                    newCandidate = Validation.checkOrder(userInput.nextLine().trim());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is invalid
                    System.out.println(iae.getMessage());
                }
            } while (true);

            // Stop creating new candidata data
            if (!newCandidate) {
                switch (type) {
                    case 0: // Print list of created Experience candidate
                        printNewExperience();
                        break;

                    case 1: // Print list of created Fresher candidate
                        printNewFresher();
                        break;

                    case 2:// Print list of created Intern candidate
                        printNewIntern();
                        break;
                }
                return; // Stop creating process
            }
        }

    }

    /**
     * Create new experience candidate
     */
    public void createExperience(Candidate candidates) {
        int expInYear;
        String proSkill;
        Scanner userInput = new Scanner(System.in); // Create new object of Scanner class

        /*Input Experience candidate experience in year*/
        do { // Make sure year inputted is valid
            try {
                System.out.print("- Please enter candidate's years of experiences: ");
                // Input and validate year of experience
                expInYear = Validation.checkYearOfExperience(userInput.nextInt(), candidates.getBirthDate());
                userInput.nextLine();
                break;
            } catch (IllegalArgumentException iae) { // Throw when year is out of range
                System.out.println(iae.getMessage());
            } catch (Exception e) { // Throw when year is non-numerical
                System.out.println("Please enter non-negative integer only [0-100]!");
                userInput.nextLine();
            }
        } while (true);

        /*Input Experience candidate's professional skill*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's professional skill: ");
                // Input and validate professional skill
                proSkill = Validation.checkString(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        // Add new Experience candidate data to main list
        candidate.add(new Experience(candidates, expInYear, formatString(proSkill)));
    }

    /**
     * Create new fresher candidate
     */
    public void createFresher(Candidate candidates) {
        int graduateDate;
        String graduationRank, education;
        Scanner userInput = new Scanner(System.in); // Create object of Scanner class

        /*Input Fresher candidate's graduate date*/
        do { // Make sure year inputted is valid
            try {
                System.out.print("- Please enter candidate's date of graduation: ");
                // Input and validate graduate date
                graduateDate = Validation.checkGraduationDate(candidates.getBirthDate(), userInput.nextInt());
                userInput.nextLine();
                break;
            } catch (IllegalArgumentException iae) { // Throw when year is out of range
                System.out.println(iae.getMessage());
            } catch (Exception e) { // Throw when year is non-numerical
                int currentYear = Year.now().getValue(); // Get the current year for comparison
                System.out.println("The candidate's grduation date must be an integer From " + candidates.getBirthDate() + " to " + currentYear + "!");
                userInput.nextLine();
            }
        } while (true);

        /*Input Fresher candidate's graduate rank*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's graduation rank [Excellence, Good, Fair, Poor]: ");
                // Input and validate graduate rank
                graduationRank = Validation.checkRank(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is invalid
                System.out.println(iae.getMessage());
            }
        } while (true);

        /*Input Fresher candidate's graduate place*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's graduation place: ");
                // Input and validate graudate place
                education = Validation.checkString(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        // Add new Fresher candidate data to main list
        candidate.add(new Fresher(candidates, graduateDate, formatString(graduationRank), formatString(education)));
    }

    /**
     * Create internship candidate
     */
    public void createIntern(Candidate candidates) {
        String major, semester, universityName;
        Scanner userInput = new Scanner(System.in); // Create an object from Scanner class

        /*Input Intern candidate's major*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's major: ");
                // Input and validate major
                major = Validation.checkString(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        /*Input Intern candidate's semester*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's semester: ");
                // Input and validate major
                semester = Validation.checkString(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        /*Input Intern candidate's university name*/
        do { // Make sure value inputted is valid
            try {
                System.out.print("- Please enter candidate's university name: ");
                // Input and validate major
                universityName = Validation.checkString(userInput.nextLine().trim());
                break;
            } catch (IllegalArgumentException iae) { // Throw when value is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        // Add new Intern candidate data to main list
        candidate.add(new Intern(candidates, formatString(major), formatString(semester), formatString(universityName)));
    }

    /**
     * Search candidate with given input
     */
    public void searchCandidate() {
        Scanner userInput = new Scanner(System.in); // Create an object from Scanner class
        String nameInput = "";
        int typeInput = 0;

        printNameList(); // Print list of candidate name

        // Implement when data is available
        if (candidate.size() != 0) {

            /*Input candidate's name*/
            do { // Makre sure value inputted is valid                
                try {
                    System.out.print("Input Candidate name (First name or last name): ");
                    // Input and validate name
                    nameInput = Validation.checkString(userInput.nextLine().trim());
                    break;
                } catch (IllegalArgumentException iae) { // Throw when value is empty
                    System.out.println(iae.getMessage());
                }
            } while (true);

            /*Input candidate's type*/
            do { // Make sure type inputted is valid
                try {
                    System.out.print("Input type of candidate: ");
                    // Input and validate type
                    typeInput = Validation.checkRange(userInput.nextInt(), 0, 2);
                    userInput.nextLine();

                    break;
                } catch (IllegalArgumentException iae) { // Throw when type is out of range
                    System.out.println(iae.getMessage());
                } catch (Exception e) { // Throw when type is non-numerical
                    System.out.println("The candidate' type must be an integer from 0 to 2!");
                    userInput.nextLine();
                }
            } while (true);

            // Create a list to store suitable given information
            ArrayList<Integer> dataList = new ArrayList<>();
            int index = 0; // Keep track of list number
            for (Candidate c : candidate) { // Traverse through main list to find suitable candidate data
                if (c.getType() == typeInput && (c.getFirstName().toLowerCase().contains(nameInput.toLowerCase()) || c.getLastName().toLowerCase().contains(nameInput.toLowerCase()))) {
                    dataList.add(index); // Add index of suitable candidate data found
                    index++; // Increase list number
                } else {
                    index++; // increase list number
                }
            }

            String[] candidateType = {"Experience", "Fresher", "InternShip"};

            if (dataList.size() == 0) { // Print when no suitable candidate data is found
                System.out.println("No candidate found with given data!\n");
            } else { // Display list of suitable candidate data
                System.out.println("The candidates found:");
                System.out.println("+---+----------------+---------+-------------+-----------+-----------------+----------+");
                System.out.println("|No.|Fullname        |Birthdate|Address      |Phone      |Email            |Type      |");
                System.out.println("+---+----------------+---------+-------------+-----------+-----------------+----------+");

                index = 0; // Keep track of list number
                for (Integer i : dataList) { // Traverse through index list
                    Candidate c = this.candidate.get(i); // Get data from main list index
                    String fullName = c.getFirstName() + " " + c.getLastName(); // Get candidate's full name
                    // Print candidate data with given format
                    System.out.printf("|%3d|%-16s|%9d|%-13s|%11s|%-17s|%-10s|\n", ++index, shortenString(fullName, 16),
                            c.getBirthDate(), shortenString(c.getAddress(), 13), shortenString(c.getPhone(), 11), shortenString(c.getEmail(), 17), candidateType[c.getType()]);
                }
                System.out.println("+---+----------------+---------+-------------+-----------+-----------------+----------+\n");
            }
        }
    }

    /**
     * Print list of candidate's full name
     */
    private void printNameList() {
        if (candidate.size() == 0) { // Print when no caendidate data is available
            System.out.println("No candidate data is available at the moment!");
        } else { // Print list of different candidate type
            int candidateCount; // Keep track of available data type

            /*Print list of Experience candidate*/
            System.out.println("List of candidate:");
            System.out.println("===========EXPERIENCE CANDIDATE===========");

            candidateCount = 0; // Keep track of available Experience type
            for (Candidate c : candidate) { // Traverse through the main list to find Experience data
                if (c instanceof Experience) {
                    ++candidateCount; // Indicate Experience type data is available
                    System.out.println(c.getFirstName() + " " + c.getLastName());
                }
            }
            if (candidateCount == 0) { // Print when no Experience type data is available
                System.out.println("No Experience candidate is currently available!");
            }

            candidateCount = 0; // Reset available data type
            System.out.println("===========FRESHER CANDIDATE===========");
            for (Candidate c : candidate) { // Traverse through main list to find Fresher data
                if (c instanceof Fresher) {
                    ++candidateCount; // Indicate Fresher type data is available
                    System.out.println(c.getFirstName() + " " + c.getLastName());
                }
            }
            if (candidateCount == 0) { // Print when no Fresher type data is found
                System.out.println("No Fresher candidate is currently available!");
            }

            candidateCount = 0; // Reset available data type
            System.out.println("===========INTERN CANDIDATE===========");
            for (Candidate c : candidate) { // Traverse through main list to find Intern data
                if (c instanceof Intern) {
                    ++candidateCount; // Indicate Intern data type is available
                    System.out.println(c.getFirstName() + " " + c.getLastName());
                }
            }
            if (candidateCount == 0) { // Print when no Intern data type is available
                System.out.println("No Intern candidate is currently available!");
            }
        }

        System.out.println();
    }

    /**
     * Print created Experience candidate
     */
    private void printNewExperience() {
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+------------------+------------------+");
        System.out.println("|No.|ID    |Fullname        |Birthdate|Address      |Phone      |Email            |Type      |Year Of Experience|Professional Skill|");
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+------------------+------------------+");
        int i = 0; // Keep track of list number
        for (Candidate c : candidate) { // Traverse through main list to find Experience data
            if (c instanceof Experience) {
                String fullName = c.getFirstName() + " " + c.getLastName(); // Get Experience candidate's full name
                // Print Experience candidate data with given format
                System.out.printf("|%3d|%-6s|%-16s|%9d|%-13s|%11s|%-17s|Experience|%18d|%-18s|\n",
                        ++i, c.getId(), shortenString(fullName, 16), c.getBirthDate(), shortenString(c.getAddress(), 13),
                        shortenString(c.getPhone(), 11), shortenString(c.getEmail(), 17), ((Experience) c).getExpInYear(),
                        shortenString(((Experience) c).getProSkill(), 18));
            }
        }
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+------------------+------------------+\n");
    }

    /**
     * Print created Fresher candidate
     */
    private void printNewFresher() {
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+-------+-------------+-------------+---------+");
        System.out.println("|No.|ID    |Fullname        |Birthdate|Address      |Phone      |Email            |Type   |Graduate Time|Graduate Rank|Education|");
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+-------+-------------+-------------+---------+");
        int i = 0; // Keep track of list number
        for (Candidate c : candidate) { // Traverse through main list to find Fresher candidate data
            if (c instanceof Fresher) {
                String fullName = c.getFirstName() + " " + c.getLastName(); // Get Fresher candidate's full name
                // Print Fresher candidate data with given format
                System.out.printf("|%3d|%-6s|%-16s|%9d|%-13s|%11s|%-17s|Fresher|%13d|%-13s|%-9s|\n",
                        ++i, c.getId(), shortenString(fullName, 16), c.getBirthDate(), shortenString(c.getAddress(), 13),
                        shortenString(c.getPhone(), 11), shortenString(c.getEmail(), 17), ((Fresher) c).getGraduateDate(),
                        ((Fresher) c).getGraduationRank(), shortenString(((Fresher) c).getEducation(), 9));
            }
        }
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+-------+-------------+-------------+---------+\n");
    }

    /**
     * Print created Intern candidate
     */
    private void printNewIntern() {
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+-------------+-------------+---------------+");
        System.out.println("|No.|ID    |Fullname        |Birthdate|Address      |Phone      |Email            |Type      |Major        |Semester     |University Name|");
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+-------------+-------------+---------------+");
        int i = 0; // Keep track of list number
        for (Candidate c : candidate) { // Traverse through main list to find Intern candidate data
            if (c instanceof Intern) {
                String fullName = c.getFirstName() + " " + c.getLastName(); // Get Fresher candidate's full name
                // Print Intern candidate data with given format
                System.out.printf("|%3d|%-6s|%-16s|%9d|%-13s|%11s|%-17s|Internship|%-13s|%-13s|%-15s|\n",
                        ++i, c.getId(), shortenString(fullName, 16), c.getBirthDate(), shortenString(c.getAddress(), 13),
                        shortenString(c.getPhone(), 11), shortenString(c.getEmail(), 17), c.getType(), shortenString(((Intern) c).getMajor(), 13),
                        shortenString(((Intern) c).getSemester(), 13), shortenString(((Intern) c).getUniversityName(), 15));
            }
        }
        System.out.println("+---+------+----------------+---------+-------------+-----------+-----------------+----------+-------------+-------------+---------------+\n");
    }

    /**
     * Check if candidate's ID has existed
     *
     * @param candidate
     * @param id
     * @return
     */
    private static boolean checkIdExist(String id) {
        for (Candidate c : candidate) { // Traverse through main list to find given ID
            if (c.getId().equalsIgnoreCase(id)) { // Throw when candidate's ID has already existed
                throw new IllegalArgumentException("The candidate's ID has already existed!");
            }
        }
        return true;
    }

    /**
     * Check if candidate's email has already existed
     *
     * @param email
     * @return
     */
    private static boolean checkEmailExist(String email) {
        for (Candidate c : candidate) { // Traverse through main list to find email
            if (c.getEmail().equalsIgnoreCase(email)) { // Throw when candidate's email has already existed
                throw new IllegalArgumentException("The candidate's email has already existed!");
            }
        }

        return true;
    }

    /**
     * Check if candidate's phone has already existed
     *
     * @param phone
     * @return
     */
    private static boolean checkPhoneExist(String phone) {
        for (Candidate c : candidate) { // Traverse through main list to find phone number
            if (c.getPhone().equals(phone)) { // Throw when candidate's phone number has already existed
                throw new IllegalArgumentException("The candidate's phone has already existed!");
            }
        }

        return true;
    }

    /**
     * Format name with given length
     *
     * @param str
     * @return new string with given length
     */
    private String shortenString(String str, int length) {
        String newStr; // Store inputted string
        if (str.length() > length) { // Shorten the string with given length and format
            newStr = str.substring(0, length - 3) + "...";
        } else {
            newStr = str;
        }

        return newStr;
    }

    /**
     * Format string into word with only the first character is uppercase
     *
     * @param str
     * @return new string with given format
     */
    private String formatString(String str) {
        String[] word = str.trim().split("\\s"); // Split the string in to array element using white space

        // Store first formatted element
        String newStr = "" + Character.toUpperCase(word[0].charAt(0)) + word[0].substring(1).toLowerCase();

        // Store the rest of the formatted element in main string
        for (int i = 1; i < word.length; i++) {
            if (word[i].equals("")) { // Leave out un-needed element
                continue;
            } else {
                // Format elements
                word[i] = "" + Character.toUpperCase(word[i].charAt(0)) + word[i].substring(1).toLowerCase();
                // Add new element to main string
                newStr += " " + word[i];
            }
        }

        return newStr;
    }
}
