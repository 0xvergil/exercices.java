import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length != 2) {
            return;
        }
        Path in = Paths.get(args[0]);
        Path out = Paths.get(args[1]);
        Files.writeString(out, capitalize(Files.readString(in)));
    }

    public static String capitalize(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (String w : s.trim().split(" +")) {
            if (!w.isEmpty()) {
                res.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase()).append(' ');
            }
        }
        return res.toString().trim();
    }
}