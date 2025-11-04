public class StringReplace {
    public static String replace(String original, char target, char replacement) {
        if (original == null) return null;
        return original.replace(target, replacement);
    }
    public static String replace(String original, char target, String replacement) {
        if (original == null || replacement == null) return null;
        return original.replace(Character.toString(target), replacement);
    }
    public static String replace(String original, String target, char replacement) {
        if (original == null || target == null) return null;
        return original.replace(target, Character.toString(replacement));
    }
    public static String replace(String original, String target, String replacement) {
        if (original == null || target == null || replacement == null) return null;
        return original.replace(target, replacement);
    }
}