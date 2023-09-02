package stringcounter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author DatDDCE171299
 */
public class Counter {

    // Create an instance from Hashmap class to count letter occurrence
    private HashMap<String, Integer> letterCounter;
    // Create a instance from Hashmap class to count character occurrence
    private HashMap<Character, Integer> characterCounter;
    private String str;

    /**
     * Create a constructor that assign a string value
     *
     * @param str
     * @throws Exception
     */
    public Counter(String str) throws Exception {
        setString(str); // Set the string value
    }

    /**
     * Set the string value
     *
     * @param str
     * @throws Exception
     */
    public void setString(String str) throws Exception {
        if (str.trim().equals("")) { // Throw when string inputted is left blank
            throw new Exception("The string cannot be empty!");
        }

        // Assign string value
        this.str = str;
    }

    /**
     * Get the string value
     *
     * @return
     */
    public String getString() {
        return str;
    }

    /**
     * Count each character number of occurrences
     */
    public void countCharacter() {
        int count; // Create a variable that store characters number of occurrences
        characterCounter = new HashMap<>(); // Create a new instance of HashMap class

        // Delete all blank spaces of the string
        String newStr = str.replaceAll(" ", "");
        for (int index = 0; index < newStr.length(); index++) {
            char c = newStr.charAt(index); // Store the character of the given index

            // Increase the character occurrence number up by 1 when the same character is found            
            // Or else add new character to the hash map and set the character occurrence to 1
            if (characterCounter.containsKey(c)) {
                count = characterCounter.get(c);
                characterCounter.put(c, count + 1);
            } else {
                characterCounter.put(c, 1);
            }
        }
    }

    /**
     * Count each letter number of occurrence
     */
    public void countLetter() {
        int count; // Create a variable that store letters number of occurrences
        String newStr = str.toLowerCase(); // Set the string to lower case
        StringTokenizer stk = new StringTokenizer(newStr, "~`!@#$%^&*()_=+[{]}\\|;:'\",<.>/? "); // Tokenize a string into list of letters

        letterCounter = new HashMap<>(); // Create a new instance of HashMap class

        while (stk.hasMoreTokens()) { // Traverse through the whole tokenized list
            String letter = stk.nextToken(); // Store each element

            // Increase the letter occurrence number up by 1 when the same letter is found
            // Or else add new letter to the hash map and set the letter occurrence to 1
            if (letterCounter.containsKey(letter)) {
                count = letterCounter.get(letter);
                letterCounter.put(letter, count + 1);
            } else {
                letterCounter.put(letter, 1);
            }
        }
    }

    /**
     * Print the list of characters number of occurrences
     */
    public String printCharacter() {
        String s = "{";
        int count = 0; // Check for printing condition
        for (Map.Entry<Character, Integer> set : characterCounter.entrySet()) {

            if (count == 0) {
                s += set.getKey() + "=" + set.getValue(); // Print the first character
            } else {
                s += ", " + set.getKey() + "=" + set.getValue(); // Print the rest of the list
            }            
            count++;
        }
        s += "}";
        return s;
    }

    /**
     * Print the list of letters number of occurrences
     */
    public String printLetter() {
        String s = "{";
        int count = 0; // Check for printing condition
        for (Map.Entry<String, Integer> set : letterCounter.entrySet()) {

            if (count == 0) {
                s += set.getKey() + "=" + set.getValue(); // Print the first character
            } else {
                s += ", " + set.getKey() + "=" + set.getValue(); // Print the rest of the list
            }            
            count++;
        }
        s += "}";
        return s;
    }
}
