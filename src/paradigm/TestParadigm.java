package paradigm;

import java.util.HashMap;

/**
 * A program to test whether two strings are paradigm.
 * @author Hai Hua (Ryan) Tan
 * @version 1.0
 */
public class TestParadigm {
    /**
     * Main method.
     * @param args
     *        command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(args[0] + " and " + args[1]
                    + (isParadigm(args[0], args[1]) ? " are " : " are not ")
                    + "paradigm");
        } else {
            System.out.println("Invalid arguments.");
        }

    }

    /**
     * Test whether the two string are paradigm.
     * @param str1
     *        First string to be compared.
     * @param str2
     *        Second string to be compared.
     * @return true if the two strings are paradigm.       
     */
    public static boolean isParadigm(final String str1, final String str2) {
        // Not a paradigm if the lengths of two string are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Change to lower case and build a mutable string from str2
        String s1 = str1.toLowerCase();
        StringBuilder s2 = new StringBuilder(str2.toLowerCase());

        // A loop to search if each character in string 1 is also in string 2
        for (int i = 0; i < s1.length(); i++) {
            // Find whether the character in s1[i] in s2
            // O(n) = ???
            int pos = s2.indexOf(s1.substring(i, i + 1));

            // If not found, stop
            if (pos == -1) {
                break;
            } else {
                // Delete the character from s2
                s2.delete(pos, pos + 1);
            }
        }
        return (s2.length() == 0);
    }

    /**
     * The other ways to test paradigm using HashMap.
     * @param str1
     *        First string to be compared.
     * @param str2
     *        Second string to be compared.
     * @return true if the two strings are paradigm.       
     */
    public static boolean isParadigm2(final String str1, final String str2) {
        // Not a paradigm if the lengths of two string are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create two HashMap to store the number of each characters.
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            Character c1 = Character.toLowerCase(str1.charAt(i));
            Character c2 = Character.toLowerCase(str2.charAt(i));
            // If the key is not added, add one.
            if (map1.get(c1) == null) {
                map1.put(c1, 1);
            } else {
                // Else accumulate the number
                map1.put(c1, map1.get(c1) + 1);
            }

            // The same handling to s2
            if (map2.get(c2) == null) {
                map2.put(c2, 1);
            } else {
                map2.put(c2, map2.get(c2) + 1);
            }
        }
        return map1.equals(map2);
    }
}
