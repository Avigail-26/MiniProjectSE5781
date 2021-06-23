package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;
/*
 *represents a sphere in a 3D Cartesian coordinate system
 */

public class Sphere extends RadialGeometry {
    /**
     * fields (center)
     */
    final protected Point3D _center;

    /**
     * Constructor for Sphere class, gets a radius and a center point3D, and creates a new sphere
     *
     * @param radius radius of a sphere
     * @param center a point3D, the center point of a sphere
     */
    public Sphere(double radius, Point3D center) {
        super(radius);
        _center = center;
    }

    /**
     * getter
     *
     * @return middle of the sphere
     */
    public Point3D getCenter() {
        return _center;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }

    /**
     * @param p
     * @return
     */
    @Override
    public Vector getNormal(Point3D p) {
        Vector O_P = p.subtract(_center);
        return O_P.normalize();
    }

    /**
     * find intersections point3D with sphere
     *
     * @param ray ray for casting
     * @return list of intersections point3D or null if there were not found
     */


//    @Override
//    public List<GeoPoint> findGeoIntersections(Ray ray, double distance) {
//        // 𝑢 = 𝑂 − 𝑃0 distance from the center and the p0
//        Point3D p0 = ray.getP0();
//        Vector v = ray.getDir();
//
//        double tm = 0;
//        double d = 0;
//        //tm=v*u the distance between p0 and the point with makes 90 degrees with the center
//        if (!p0.equals(_center)) {
//            Vector u = _center.subtract(p0);
//
//            tm = u.dotProduct(v);
//
//            d = alignZero(Math.sqrt(u.lengthSquared() - tm * tm));
//        }
//
//        //d=u^2+tm^2 distance between the center and the point that  makes 90 degrees with the center
//        if (d >= _radius) {
//            return null;
//        }
//        double th = alignZero(Math.sqrt(_radius * _radius - d * d));
//
//        //P is on the surface of the sphere
//        if (isZero(th)) {
//            return null;
//        }
//        double t1 = alignZero(tm - th);
//        double t2 = alignZero(tm + th);
//        boolean t1Valid = alignZero(t1 - distance) <= 0;
//        boolean t2Valid = alignZero(t2 - distance) <= 0;
//        if (t1 > 0 && t2 > 0 && t1Valid && t2Valid) {
//            Point3D p1 = p0.add(v.scale(t1));
//            Point3D p2 = p0.add(v.scale(t2));
//
//            return List.of(new GeoPoint(this, p1), new GeoPoint(this, p2));
//        }
//        if (t1 > 0 && t1Valid) {
//            Point3D p1 = p0.add(v.scale(t1));
//
//            return List.of(new GeoPoint(this, p1));
//        }
//        if (t2 > 0 && t2Valid) {
//            Point3D p2 = p0.add(v.scale(t2));
//
//            return List.of(new GeoPoint(this, p2));
//        }
//        return null;
//    }

    public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
        Point3D p0 = ray.getP0();
        Point3D O = _center;
        Vector V = ray.getDir();
        if (p0.equals(O)) {//if the ray start is in the center of the sphere
            return (List.of(new GeoPoint(this, ray.getPoint(_radius))));
        }
        Vector U = O.subtract(p0);
        double tm = V.dotProduct(U);
        double d = Math.sqrt((U.lengthSquared() - tm * tm));
        if (d >= _radius) { //there is no intersections
            return null;
        }
        double th = Math.sqrt(_radius * _radius - d * d);
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        //if t1 or t2 is negative, the intersection is before the ray start
        if (t1 > 0 && t2 > 0 && alignZero(t1 - maxDistance) <= 0 && alignZero(t2 - maxDistance) <= 0) {
            Point3D p1 = ray.getPoint(t1);
            Point3D p2 = ray.getPoint(t2);
            return List.of(new GeoPoint(this, p1), new GeoPoint(this, p2));
        }
        if (t2 > 0 && alignZero(t2 - maxDistance) <= 0) {
            Point3D p2 = ray.getPoint(t2);
            return List.of(new GeoPoint(this, p2));
        }
        if (t1 > 0 && alignZero(t1 - maxDistance) <= 0) {
            Point3D p1 = ray.getPoint(t1);
            return List.of(new GeoPoint(this, p1));
        }
        return null;
    }


}
