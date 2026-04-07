import java.util.Objects;

public class CelestialObject {
    public double x, y, z;
    public String name;
    public static double KM_IN_ONE_AU = 150000000.0;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject obj1, CelestialObject obj2) {
        double dx = obj1.x - obj2.x;
        double dy = obj1.y - obj2.y;
        double dz = obj1.z - obj2.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1, CelestialObject obj2) {
        return getDistanceBetween(obj1, obj2) * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        CelestialObject o = (CelestialObject) object;

        return Double.compare(o.x, x) == 0 &&
               Double.compare(o.y, y) == 0 &&
               Double.compare(o.z, z) == 0 &&
               Objects.equals(name, o.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}
