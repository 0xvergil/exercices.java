import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) return;
        Path out = Path.of(args[0]);
        try (OutputStream os = Files.newOutputStream(out, CREATE, TRUNCATE_EXISTING, WRITE)) {
            byte[] buf = new byte[4096];
            int n;
            while ((n = System.in.read(buf)) != -1) {
                os.write(buf, 0, n);
            }
        }
    }
}