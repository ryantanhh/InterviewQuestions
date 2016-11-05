package paradigm;

import java.util.HashMap;

public class TestParadigm {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(args[0] + " and " + args[1]
                    + (isParadigm(args[0], args[1]) ? " are " : " are not ")
                    + "paradigm");
        }
    }

    public static boolean isParadigm(final String str1, final String str2) {
        // Not paradigm if length of two string are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Build a mutable string
        StringBuilder s2 = new StringBuilder(str2);

        // A loop to search if each character in string 1 is also in string 2
        for (int i = 0; i < str1.length(); i++) {
            // Find the character in s2
            int pos = s2.indexOf(str1.substring(i, i + 1));

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
     * Using two hash map
     */
    public static boolean isParadigm2(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Character c1 = str1.charAt(i);
            Character c2 = str2.charAt(i);
            if (map1.get(c1) == null) {
                map1.put(c1, 1);
            } else {
                map1.put(c1, map1.get(c1) + 1);
            }

            if (map2.get(c2) == null) {
                map2.put(c2, 1);
            } else {
                map2.put(c2, map2.get(c2) + 1);
            }
        }
        return map1.equals(map2);
    }
}
