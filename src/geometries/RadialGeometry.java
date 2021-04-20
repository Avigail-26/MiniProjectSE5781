package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public abstract class RadialGeometry {
    final protected double _radius;

    public RadialGeometry(double radius) {
        _radius = radius;
    }

    /**
     * @return
     */
    public double getRadius() {
        return _radius;
    }

    public abstract List<Point3D> findIntersections(Ray ray);
}
