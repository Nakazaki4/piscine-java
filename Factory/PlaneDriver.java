public class PlaneDriver extends Driver {
    Transport createTransport() {
        return new Plane();
    }
}