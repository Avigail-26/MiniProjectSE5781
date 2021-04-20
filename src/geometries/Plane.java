package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

public class Plane implements Geometry
{
    /**
     *fields of class Plane
     */
    final Point3D _q0;
    final Vector _normal;

    /**
     * Constructor Plane with Point3D and vector normal
     * @param q0-point3D
     * @param normal-vector
     */
    public Plane(Point3D q0, Vector normal) {
        _q0 = q0;
        _normal = normal.normalized();
    }
    /**
     * Constructor Plane with three Point3D
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _q0 = p1;

        Vector U = p2.subtract(p1).normalize();
        Vector V = p3.subtract(p1).normalize();

        Vector N = U.crossProduct(V);

        N.normalize();
        _normal = N;

    }


    /**
     * Function ToString
     * @return string with point and normal
     */
    @Override
    public String toString() {
        return  "point" + _q0 +  ", normal" + _normal;
    }

    /**
     * getter for reference point of the Plane
     * @return the reference point
     */
    public Point3D getQ0() {
        return _q0;
    }

    /**
     * getter for normal field of the Plane
     * @deprecated use instead the {@link Plane#getNormal(Point3D)} with null as parameter value.
     * @return normal vector
     */
    @Deprecated
    public Vector getNormal() {
        return _normal;
    }

    /**
     * implementation of getNormal from Geometry interface
     * @param point
     * @return
     */
    @Override
    public Vector getNormal(Point3D point) {
        return _normal;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D P0 = ray.getP0();
        ;
        Vector v = ray.getDir();

        if (_q0.equals(P0)){
            return  List.of(_q0);
        }
        double nv = _normal.dotProduct(v);

        //the ray is lying on the plane
        if (isZero(nv)) {
            return null;
        }
        //explication a suivre...
        double t = _normal.dotProduct(_q0.subtract(P0));
        t /= nv;

        Point3D p = ray.getTargetPoint(t);
        return List.of(p);
    }


}

