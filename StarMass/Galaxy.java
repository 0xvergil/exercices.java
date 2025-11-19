import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject celestialObject) {
        this.celestialObjects.add(celestialObject);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> result = new HashMap<>();
        result.put("Star", 0);
        result.put("Planet", 0);
        result.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            String key;
            if (obj instanceof Star) {
                key = "Star";
            } else if (obj instanceof Planet) {
                key = "Planet";
            } else {
                key = "Other";
            }
            int sum = result.get(key);
            sum += obj.getMass();
            result.put(key, sum);
        }
        return result;
    }
}
