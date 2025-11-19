import java.util.*;

public class SortList {

   public static List<Integer> sort(List<Integer> list) {
      if (list == null) {
         return null;
      }
      if (list.size() == 0) {
         return list;
      }
      List<Integer> lis = new ArrayList<>(list);
      lis.sort(null);
      return lis;
   }

   public static List<Integer> sortReverse(List<Integer> list) {
      if (list == null) {
         return null;
      }
      if (list.size() == 0) {
         return list;
      }
      List<Integer> lis = new ArrayList<>(list);
      lis.sort(null);
      Collections.reverse(lis);
      return lis;
   }
}