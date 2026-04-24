
import java.util.List;

public class BinaryBaseObserver implements NumericBaseObserver{

    private List<String> events;

    @Override
    public void updateState(int state) {
        this.events.add(Integer.toBinaryString(state));
    }

    @Override
    public List<String> getEvents() {
        return this.events;
    }
}
