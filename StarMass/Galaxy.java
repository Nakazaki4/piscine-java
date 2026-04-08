
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void setCelestialObjects(List<CelestialObject> coList) {
        this.celestialObjects = coList;
    }

    public void addCelestialObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> map = new HashMap<>();
        int planetsMass = 0, other = 0, starsMass = 0;

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                starsMass += obj.getMass();
            } else if (obj instanceof Planet) {
                planetsMass += obj.getMass();
            } else {
                other += obj.getMass();
            }
        }
        map.put("Star", starsMass);
        map.put("Planet", planetsMass);
        map.put("Other", other);

        return map;
    }
}