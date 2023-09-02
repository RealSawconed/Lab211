package j1.s.p0012;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class GUI {

    private DoctorHash dh; // Create an object from DoctorHash class

    /**
     * Print main menu
     */
    public void menu() {
        System.out.println("   DOCTOR MANAGEMENT");
        System.out.println("1. Add Doctor.");
        System.out.println("2. Update Doctor.");
        System.out.println("3. Delete Doctor.");
        System.out.println("4. Search Doctor.");
        System.out.println("5. Exit.");
        System.out.print("   Please choose: ");
    }

    /**
     * Create a default constructor that initialize object from DoctorHash class
     */
    public GUI() {
        dh = new DoctorHash();
    }

    /**
     * Add new doctor's data
     */
    public void addDoctor() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        System.out.println("--------- Add Doctor ---------");

        // Input code
        do { // Make sure code is valid
            System.out.print("Enter Code: ");
            try {
                // Input and validate code
                String code = Validation.checkCode(input.nextLine());
                if (dh.checkCodeExist(code)) { // Throw when code is already existed
                    throw new IllegalArgumentException("The doctor's code has already existed!");
                } else { // Set code for doctor
                    dh.setCode(code);
                }

                break;
            } catch (IllegalArgumentException iae) {  // Throw when code is already existed 
                System.out.println(iae.getMessage()); // or is not follow given pattern
            }
        } while (true);

        // Input name
        do { // Make sure name is valid
            System.out.print("Enter Name: ");
            try {
                // Input and validate name
                String name = Validation.checkString(input.nextLine());
                dh.setName(formatString(name)); // Set name for doctor

                break;
            } catch (IllegalArgumentException iae) { // Throw when name is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        // Input specialization
        do { // Make sure specialization is valid
            System.out.print("Enter Specialization: ");
            try {
                // Input and validate specialization
                String specialization = Validation.checkString(input.nextLine());
                // Set the specialization for doctor
                dh.setSpecialization(formatString(specialization));

                break;
            } catch (IllegalArgumentException iae) { // Throw when specialization is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        // Input availability
        do { // Make sure availability is valid
            System.out.print("Enter Availability: ");
            try {
                // Input and validate availability
                int availability = Validation.checkRange(input.nextInt(), 0);
                input.nextLine();
                // Set the availability for doctor
                dh.setAvailability(availability);

                break;
            } catch (NumberFormatException nfe) { // Throw when availability is out of range
                System.out.println("Please enter non-negative integer only");
                input.nextLine();
            } catch (Exception e) { // Throw when availability is non-numerical
                System.out.println("Please enter non-negative integer only!");
                input.nextLine();
            }
        } while (true);

        dh.add(); // Add new doctor's data
        System.out.println("New doctor's data has been added successfully!\n");
    }

    /**
     * Update current doctor's data with given code
     */
    public void updateDoctor() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        // Display context or list if data are available
        display("--------- Update Doctor ---------\n"
                + "########## Doctor Data ##########");

        // Update if list data is available
        if (dh.getSize() != 0) {

            // Input code
            do { // Make sure code is valid
                try {
                    // Input and validate code
                    System.out.print("Enter Code: ");
                    String code = Validation.checkCode(input.nextLine());
                    if (!dh.checkCodeExist(code)) { // Throw when user input is not existed in list
                        throw new IllegalArgumentException("The doctor with code \"" + code + "\" is not found!");
                    } else {
                        dh.setCode(code); // Set code to update
                    }

                    break;
                } catch (IllegalArgumentException iae) { // Throw when code is empty or
                    System.out.println(iae.getMessage());// not follow given syntax
                }
            } while (true);

            // Input name
            System.out.print("Enter Name: ");
            dh.setName(formatString(input.nextLine())); // Set name for doctor

            // Input specialization
            System.out.print("Enter Specialization: ");
            dh.setSpecialization(formatString(input.nextLine())); // Set specialization for doctor

            // Input availability
            do {
                System.out.print("Enter Availability: ");
                try {
                    String avl = input.nextLine(); // Store input string
                    if (avl.trim().equals("")) { // Check condition when input is blank
                        dh.setAvailability(-1);
                    } else { // Set and validate value for doctor's availability
                        dh.setAvailability(Validation.checkRange(Integer.parseInt(avl), 0));
                    }

                    break;
                } catch (NumberFormatException nfe) { // Throw when availability is out of range
                    System.out.println("Please enter non-negative integer only");
                } catch (Exception e) { // Throw when availability is neither blank nor non-numerical
                    System.out.println("Please enter non-negative integer only!");
                    input.nextLine();
                }
            } while (true);

            dh.update(); // Update current doctor's data with given code
            System.out.println("New doctor's data has been updated successfully!");
            display("########## Doctor Data ##########"); // Display new list
        }
        System.out.println();
    }

    /**
     * Delete current doctor's data with given code
     */
    public void deleteDoctor() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        // Display context or list if data is available
        display("--------- Delete Doctor ---------\n"
                + "########## Doctor Data ##########");

        // Delete if doctor's data is available
        if (dh.getSize() != 0) {

            // Input code
            do { // Make sure code is valid
                try {
                    System.out.print("Enter Code: ");
                    // Input and validate code
                    String code = Validation.checkCode(input.nextLine());
                    if (!dh.checkCodeExist(code)) { // Throw when code is not in data list
                        throw new IllegalArgumentException("No doctor's data with code \"" + code + "\" existed!");
                    } else {
                        dh.setCode(code); // Set code for delete
                    }

                    break;
                } catch (IllegalArgumentException iae) { // Throw when user input is empty or
                    System.out.println(iae.getMessage());// not follow given syntax
                }
            } while (true);

            dh.delete(); // Delete current doctor's data with given code
            System.out.println("Doctor's data has been deleted successfully!");
            display("########## Doctor Data ##########"); // Display new list
        }

        System.out.println();
    }

    /**
     * Search doctor's data with given information text
     */
    public void searchDoctor() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        // Display context or list if data are available
        display("--------- Search Doctor ---------");

        // Search if data is available
        if (dh.getSize() != 0) {
            String str; // Store input string

            // Input text
            do { // Make sure text is valid
                System.out.print("Enter text: ");
                try {
                    // Input and validate string
                    str = Validation.checkString(input.nextLine());

                    break;
                } catch (IllegalArgumentException iae) { // Throw when string is empty
                    System.out.println(iae.getMessage());
                }
            } while (true);

            // Create a newlist to store found data list
            Hashtable<String, DoctorHash> foundList = dh.search(str);

            // Print if no suitable data is found
            if (foundList.size() == 0) {
                System.out.println("No data with content \"" + str + "\" is found in the list!");
            } else { // Print found list
                System.out.println("########## Result ##########");
                System.out.println("+------+---------------+----------------+-------------+");
                System.out.println("|Code  |Name           |Specialization  |Availability |");
                System.out.println("+------+---------------+----------------+-------------+");
                Enumeration<String> e = foundList.keys(); // Create an object to traverse through list
                while (e.hasMoreElements()) { // Loop until no more element is left
                    String key = e.nextElement(); // Store current element key
                    DoctorHash d = foundList.get(key); // Store current element value
                    // Print data with given format
                    System.out.printf("|%-6s|%-15s|%-16s|%13d|\n", key, shortenString(d.getName(), 15), shortenString(d.getSpecialization(), 16), d.getAvailability());
                }
                System.out.println("+------+---------------+----------------+-------------+");
            }
        }

        System.out.println();
    }

    /**
     * Display list with given text
     *
     * @param tableTitle
     */
    private void display(String tableTitle) {
        if (dh.getSize() == 0) { // Print if no data is available
            System.out.println("No doctor's data is currently available!");
        } else { // Print list
            // Create new list that store main list
            Hashtable<String, DoctorHash> doctorList = dh.getDoctorList();

            // Print list with given text
            System.out.println(tableTitle);
            System.out.println("+------+---------------+----------------+-------------+");
            System.out.println("|Code  |Name           |Specialization  |Availability |");
            System.out.println("+------+---------------+----------------+-------------+");
            Enumeration<String> e = doctorList.keys(); // Create an object to traverse through list
            while (e.hasMoreElements()) { // Loop until no more element left
                String key = e.nextElement(); // Store current element key
                DoctorHash d = doctorList.get(key); // Store current element value
                // Display data with given format
                System.out.printf("|%-6s|%-15s|%-16s|%13d|\n", key, shortenString(d.getName(), 15), shortenString(d.getSpecialization(), 16), d.getAvailability());
            }
            System.out.println("+------+---------------+----------------+-------------+");
        }
    }

    /**
     * Shorten input string with given length
     *
     * @param str
     * @param length
     * @return
     */
    private String shortenString(String str, int length) {
        if (str.length() > length) { // Return new string with given format if length is ot of range
            return str.substring(0, length - 3) + "...";
        } else { // Return new string with no change if length is in range
            return str;
        }
    }

    private String formatString(String str) {
        if (str.trim().equals("")) { // Prevent inputted error
            return str.trim();
        } else {
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
}
