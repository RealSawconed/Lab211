package j1.s.p0011;

import java.util.Scanner;

/**
 *
 * @author DatDDCE171299
 */
public class GUI {

    private Contact contact; // Create an object from Contact class

    /**
     * Create a default constructor and initialize object from Contact class
     */
    public GUI() {
        contact = new Contact();
    }

    /**
     * Display main menu
     */
    public void menu() {
        System.out.println("   CONTACT MANAGEMENT");
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
        System.out.print("   Please choose: ");
    }

    /**
     * Add new contact information with given information
     */
    public void addContact() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        System.out.println("####### Add a Contact #######");

        // Input name
        do { // Make sure name is valid
            System.out.print("Enter Name: ");
            // Input, validate and format name
            try {
                String name = formatString(Validation.checkString(input.nextLine()));
                if (name.indexOf(" ") == -1) { // Check if name has more than 1 word
                    throw new Exception();
                } else {
                    contact.setName(name); // Set name for contact information
                }

                break;
            } catch (IllegalArgumentException iae) { // Throw when name is empty
                System.out.println("Please input name with more than 1 word!");
            } catch (Exception e) { // Throw when name contain only 1 word
                System.out.println("Please input name with more than 1 word!");
            }
        } while (true);

        // Input group
        do { // Make sure group is valid
            System.out.print("Enter Group: ");
            try {
                // Input, validate and format group
                contact.setGroup(formatString(Validation.checkString(input.nextLine())));

                break;
            } catch (IllegalArgumentException iae) { // Throw when group is empty
                System.out.println("Please input non-empty data for group!");
            }
        } while (true);

        // Input address
        do { // Make sure address is valid
            System.out.print("Enter Address: ");
            try {
                // Input, validate and format address
                contact.setAddress(formatString(Validation.checkString(input.nextLine())));

                break;
            } catch (IllegalArgumentException iae) { // Throw when address is empty
                System.out.println("Please input non-empty data for address!");
            }
        } while (true);

        // Input phone
        do { // Make sure phone is valid
            System.out.print("Enter Phone: ");
            try {
                // Input, validate and format phone with given valid pattern
                contact.setPhone(formatPhone(Validation.checkPhone(input.nextLine())));

                break;
            } catch (IllegalArgumentException iae) { // Throw when phone is empty
                System.out.println(iae.getMessage());
            }
        } while (true);

        contact.addContact(); // Add new contact information to main list
        System.out.println("Successful");
    }

    /**
     * Delete a contact with given ID
     */
    public void deleteContact() {
        Scanner input = new Scanner(System.in); // Create an object from Scanner class

        // Display context or list if data is available
        displayAll("####### Delete a Contact #######");
        // Operate if data is available
        if (contact.getSize() != 0) {
            int index; // Store index that store given ID

            // Input ID
            do { // Make sure ID is valid
                System.out.print("Enter ID: ");
                try {
                    // Input and validate ID
                    index = input.nextInt();

                    if (!contact.checkIDExist(index)) { // Throw when ID is not existed
                        throw new NumberFormatException();
                    } else { // Break the loop
                        input.nextLine();
                        break;
                    }
                } catch (NumberFormatException nfe) { // Throw when ID is not existed
                    System.out.println("Please enter ID from list!");
                    input.nextLine();
                } catch (Exception e) { // Throw when ID is non-numerical
                    System.out.println("ID is digit, Please enter ID from list!");
                    input.nextLine();
                }
            } while (true);

            contact.deleteContact(index); // Delete a contact with given ID
            System.out.println("Successful!");

            // Display context or list if data is available
            displayAll("####### Contact Update #######");
        }
    }

    /**
     * Display context whether data is available or not
     *
     * @param title
     */
    public void displayAll(String title) {
        if (contact.getSize() == 0) { // Display context if data is not availble
            System.out.println("No current contact information is available!\n");
        } else { // Display list when data is available
            System.out.println(title); // Display the given title
            System.out.println("+---+------------------------+---------------+-------------+-----------+--------------+-------------------+");
            System.out.println("| ID|Name                    |First Name     |Last Name    |Group      |Address       |Phone              |");
            System.out.println("+---+------------------------+---------------+-------------+-----------+--------------+-------------------+");

            // Get data for display
            for (int i = 0; i < contact.getSize(); i++) {
                Contact c = contact.display(i); // Store information of each ID
                int index = c.getName().indexOf(" "); // Check name length for seperation
                String firstName, lastName;
                if (index == -1) { // Name with 1 word
                    firstName = c.getName();
                    lastName = "";
                } else { // Name with multiple words
                    firstName = c.getName().substring(0, c.getName().indexOf(" ")); // Store first name
                    lastName = c.getName().substring(c.getName().indexOf(" ") + 1); // Store last name
                }

                // Display contact information for each row
                System.out.printf("|%3d|%-24s|%-15s|%-13s|%-11s|%-14s|%-19s|\n", c.getId(), shortenString(c.getName(), 24), shortenString(firstName, 15),
                        shortenString(lastName, 13), shortenString(c.getGroup(), 11), shortenString(c.getAddress(), 14), c.getPhone());
            }

            System.out.println("+---+------------------------+---------------+-------------+-----------+--------------+-------------------+");
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

    /**
     * Format string with given format
     *
     * @param str
     * @return
     */
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

    /**
     * Format phone for storing
     *
     * @param phone
     * @return
     */
    private String formatPhone(String phone) {
        // Split input phone into sections with number only
        String[] phoneDigit = phone.toLowerCase().split("[\\W]");
        String defaultPhone = ""; // Store new phone

        for (String s : phoneDigit) { // Traverse through array of digit part
            if (!s.equals("") && !(s.contains("ext") || s.contains("x"))) { // Store extension part
                defaultPhone += s;
            } else if (s.equals("")) { // Skip blank element
                continue;
            } else { // Stor digits
                defaultPhone += " " + s;
            }
        }
        // Return new phone with given format
        return defaultPhone;
    }
}
