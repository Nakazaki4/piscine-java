import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return magnitude;
    }

    public Star(){
        
    }

    public Star(String name, double x, double y, double z, double a) {
        super(name, x, y, z);
        this.magnitude = a;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return this.name + " shines at the " + String.format("%.3f magnitude", this.magnitude);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;

        Star o = (Star) object;

        return Double.compare(o.x, x) == 0 &&
                Double.compare(o.y, y) == 0 &&
                Double.compare(o.z, z) == 0 &&
                Objects.equals(name, o.name) &&
                this.magnitude == o.magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z, magnitude);
    }
}