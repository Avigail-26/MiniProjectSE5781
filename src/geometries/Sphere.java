package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry{
    /**
     *fields (center)
     */
    final Point3D _center;
    final  double _radius;

    /**
     *
     * @param center
     * @param radius
     */
    public Sphere(Point3D center, double radius) {
        _center = center;
        _radius = radius;
    }

    /**
     *
     * @return
     */
    public Point3D getCenter() {
        return _center;
    }

    /**
     *
     * @return
     */
    public double getRadius() {
        return _radius;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    /**
     *
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}
