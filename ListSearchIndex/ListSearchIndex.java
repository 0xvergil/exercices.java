import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int idx = list.lastIndexOf(value);
        if (idx == -1) {
            return null;
        }
        return idx;
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null;
        }
        int idx = list.indexOf(value);
        if (idx == -1) {
            return null;
        }
        return idx;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        if (list == null)
            return new ArrayList<>();

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i), value)) {
                indexes.add(i);
            }
        }

        return indexes;
    }

}
