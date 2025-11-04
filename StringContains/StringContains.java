public class StringContains {
    public static boolean isStringContainedIn(String sub, String s) {
        if (sub == null || s == null) {
            return false;
        }
        return s.contains(sub);
    }
}