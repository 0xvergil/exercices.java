import java.util.*;

public class WeddingComplex {

   public static Map<String, String> createBestCouple(
         Map<String, List<String>> first,
         Map<String, List<String>> second) {

      Queue<String> free = new LinkedList<>(first.keySet());
      Map<String, String> pairings = new HashMap<>();
      Map<String, String> result = new HashMap<>();

      Map<String, Map<String, Integer>> secondRank = new HashMap<>();
      for (String s : second.keySet()) {
         Map<String, Integer> rank = new HashMap<>();
         List<String> prefs = second.get(s);
         for (int i = 0; i < prefs.size(); i++) {
            rank.put(prefs.get(i), i);
         }
         secondRank.put(s, rank);
      }

      Map<String, Integer> nextProposal = new HashMap<>();
      for (String f : first.keySet()) {
         nextProposal.put(f, 0);
      }

      while (!free.isEmpty()) {
         String f = free.poll();
         List<String> preferences = first.get(f);
         int idx = nextProposal.get(f);
         String s = preferences.get(idx);
         nextProposal.put(f, idx + 1);

         if (!pairings.containsKey(s)) {
            pairings.put(s, f);
            result.put(f, s);
         } else {
            String current = pairings.get(s);
            Map<String, Integer> rank = secondRank.get(s);
            if (rank.get(f) < rank.get(current)) {
               pairings.put(s, f);
               result.put(f, s);
               free.add(current);
               result.remove(current);
            } else {
               free.add(f);
            }
         }
      }

      return result;
   }
}
