import java.util.Objects;

public class CelestialObject {
    public double x;
    public double y;
    public double z;
    public String name;
    private int mass; // NEW
    public static final double KM_IN_ONE_AU = 150_000_000d;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
        this.mass = 0;
    }

    // Keep existing constructor
    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = 0;
    }

    // NEW: constructor with mass
    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.mass = mass;
    }

    public double getX() { return this.x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return this.y; }
    public void setY(double y) { this.y = y; }
    public double getZ() { return this.z; }
    public void setZ(double z) { this.z = z; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    // NEW: mass getter/setter
    public int getMass() { return mass; }
    public void setMass(int mass) { this.mass = mass; }

    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        double dz = a.z - b.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CelestialObject)) return false;
        CelestialObject other = (CelestialObject) obj;
        return Double.compare(this.x, other.x) == 0
                && Double.compare(this.y, other.y) == 0
                && Double.compare(this.z, other.z) == 0
                && Objects.equals(this.name, other.name);
        // (Mass not included in equals per earlier behavior)
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, z);
    }
}
