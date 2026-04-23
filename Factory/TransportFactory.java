
public class TransportFactory {

    public int getTransport(String type) {
        if (type.equals("Car")) {
            return new Car().getDistance();
        } else if (type.equals("Plane")) {
            return new Plane().getDistance();
        }
        return 0;
    }
}
