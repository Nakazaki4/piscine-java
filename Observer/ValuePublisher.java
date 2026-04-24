
import java.util.List;

public class ValuePublisher {

    List<NumericBaseObserver> observers;

    public void updateState(int value) {
        this.observers.forEach(observer -> observer.updateState(value));;
    }

    public void subscribe(NumericBaseObserver observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(NumericBaseObserver observer) {
        this.observers.remove(observer);
    }
}
