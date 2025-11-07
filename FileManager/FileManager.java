import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {
   public static void createFile(String fileName, String content) throws IOException {
      Path path = Paths.get(fileName);
      Files.writeString(
            path,
            content,
            StandardCharsets.UTF_8,
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING);
   }

   public static String getContentFile(String fileName) throws IOException {
      Path path = Paths.get(fileName);
      return Files.readString(path, StandardCharsets.UTF_8);
   }

   public static void deleteFile(String fileName) {
      try {
         Files.deleteIfExists(Paths.get(fileName));
      } catch (IOException ignored) {
         //swallow exceptions since the signature doesn't declare throws.
      }
   }
}
