
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
