
import java.util.List;

public class HexaBaseObserver implements NumericBaseObserver{

    private List<String> events;

    @Override
    public void updateState(int state) {
        this.events.add(Integer.toHexString(state));
    }

    @Override
    public List<String> getEvents() {
        return this.events;
    }
}
