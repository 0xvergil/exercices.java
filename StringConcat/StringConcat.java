public class StringConcat {
    public static String concat(String one, String two) {
        if (one == null && two == null) {
            return null;
        }
        if (one == null && two != null) {
            return two;
        }
        if (one != null && two == null) {
            return one;
        }
        return one + two;
    }
}