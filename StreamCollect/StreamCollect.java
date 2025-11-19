import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {

   public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
      return s.collect(
            Collectors.groupingBy(
                  str -> Character.toUpperCase(str.charAt(0)),
                  LinkedHashMap::new, Collectors.toList()));
   }

   public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
      return s.collect(
            Collectors.groupingBy(
                  n -> n % 4,
                  Collectors.maxBy(Comparator.naturalOrder())));
   }

   public static String orderAndConcatWithSharp(Stream<String> s) {
      String joined = s
            .sorted()
            .collect(Collectors.joining(" # "));

      return "{" + joined + "}";
   }
}
