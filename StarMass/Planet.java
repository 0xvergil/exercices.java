import java.util.Locale;
import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    // UPDATED: add mass to constructor
    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() { return centerStar; }
    public void setCenterStar(Star centerStar) { this.centerStar = centerStar; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet other = (Planet) o;
        return super.equals(other) && Objects.equals(this.centerStar, other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }

    @Override
    public String toString() {
        double dAu = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format(Locale.US,
                "%s circles around %s at the %.3f AU",
                getName(), centerStar.getName(), dAu);
    }
}
