
import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private List<CelestialObject> coList;

    public Galaxy() {
        coList = new ArrayList<>();
    }

    public List<CelestialObject> getCoList() {
        return coList;
    }

    public void setCoList(List<CelestialObject> coList) {
        this.coList = coList;
    }

    public void addCelestialObject(CelestialObject obj) {
        coList.add(obj);
    }
}