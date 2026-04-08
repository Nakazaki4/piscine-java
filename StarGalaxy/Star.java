import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return magnitude;
    }

    public Star() {

    }

    public Star(String name, double x, double y, double z, double a) {
        super(name, x, y, z);
        this.magnitude = a;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String toString() {
        return this.name + " shines at the " + String.format("%.3f magnitude", this.magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Star object = (Star) obj;

        return Double.compare(object.x, x) == 0 &&
                Double.compare(object.y, y) == 0 &&
                Double.compare(object.z, z) == 0 &&
                Objects.equals(name, object.name) &&
                Double.compare(object.magnitude, magnitude) == 0;
    }

    public int hashCode() {
        return Objects.hash(name, x, y, z, magnitude);
    }
}