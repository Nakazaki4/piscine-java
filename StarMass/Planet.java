public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((centerStar == null) ? 0 : centerStar.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Planet other = (Planet) obj;
        if (super.equals(obj)) {
            return this.centerStar.equals(other.centerStar);
        }

        return false;
    }

    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distance);
    }
}
