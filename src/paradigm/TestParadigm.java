package paradigm;

public class TestParadigm {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(args[0] 
              + " and "
              + args[1]
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
        int pos = s2.indexOf(str1.substring(i, i+1)); 
        /* Big-O question：NOT n because operattion of searching depends on the length */
        
        // If not found, stop
        if (pos == -1) {
            break;
        } else {
           // Delete the character from s2
           s2.delete(pos, pos+1);
        }
       }
    return (s2.length() == 0);
    }
}
