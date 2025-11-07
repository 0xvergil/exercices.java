import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileSearch {
   public static String searchFile(String fileName) {
      Path root = Paths.get("documents");

      if (!Files.isDirectory(root)) {
         return null;
      }

      try (Stream<Path> walk = Files.walk(root)) {
         Optional<Path> match = walk
               .filter(Files::isRegularFile)
               .filter(p -> p.getFileName().toString().equals(fileName))
               .findFirst();

         if (match.isPresent()) {
            Path found = match.get();
            String rel = root.relativize(found).toString().replace('\\', '/');
            return "documents/" + rel;
         }
         return null;
      } catch (IOException e) {
         return null;
      }
   }
}
