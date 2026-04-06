
public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
}
