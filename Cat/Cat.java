import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }
        try (InputStream in = Files.newInputStream(Path.of(args[0]))) {
            byte[] buf = new byte[4096];
            int n;
            while ((n = in.read(buf)) != -1) {
                System.out.write(buf, 0, n);
            }
        }
        System.out.flush();
    }
}