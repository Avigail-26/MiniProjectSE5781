package primitives;

import java.util.List;
import java.util.Objects;

import geometries.Intersectable.GeoPoint;

import static primitives.Util.isZero;

public class Ray {
    /**
     * Fields (point3D,vector)
     */
    final Point3D _p0;
    final Vector _dir;

    /**
     * @param p0  point of origin of the ray
     * @param dir direction of the ray, normalized
     */
    public Ray(Point3D p0, Vector dir) {
        _p0 = p0;
        _dir = dir.normalized();
    }

    public Point3D getP0() {
        return _p0;
    }

    /*
    Returns:
    ray direction in new vector so the direction can't be changed
     */
    public Vector getDir() {
        return _dir;
    }

    public GeoPoint getClosestGeoPoints(List<GeoPoint> pointList) {
        GeoPoint result = null;
        double closestDistance = Double.MAX_VALUE;

        if (pointList == null) {
            return null;
        }

        for (GeoPoint geo : pointList) {
            double temp = geo.point.distance(_p0);
            if (temp < closestDistance) {
                closestDistance = temp;
                result = geo;
            }
        }

        return result;
    }

    /*
    Params:
        o – ray to compare to
    Returns:
        true if direction and head are the same in both rays
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals(ray._p0) && _dir.equals(ray._dir);
    }

    @Override
    public String toString() {
        return "[" + _p0 + _dir + ']';
    }

    public Point3D getTargetPoint(double t) {
        if (isZero(t)) {
            return _p0;
        }
        return _p0.add(_dir.scale(t));
    }

    /**
     * find the closest Point to Ray origin
     *
     * @param pointsList intersections point List
     * @return closest point
     */
    public Point3D findClosestPoint(List<Point3D> pointsList) {
        Point3D result = null;
        double closestDistance = Double.MAX_VALUE;

        if (pointsList == null) {
            return null;
        }

        for (Point3D p : pointsList) {
            double temp = p.distance(_p0);
            if (temp < closestDistance) {
                closestDistance = temp;
                result = p;
            }
        }

        return result;
    }
}
