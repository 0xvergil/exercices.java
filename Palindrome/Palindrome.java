public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(reversed)) {
            return true;
        }
        return false;
    }
}