package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Plane implements Geometry
{
    /**
     *fields of class Plane
     */
    final Point3D _q0;
    final Vector _normal;

    /**
     * Constructor Plane with Point3D and vector normal
     * @param _q0-point3D
     * @param _normal-vector
     */
    public Plane(Point3D _q0, Vector _normal) {
        this._q0 = _q0;
        this._normal = _normal;
    }
    /**
     * Constructor Plane with three Point3D
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _q0 = p1;

        Vector U = new Vector(p2.subtract(p1));
        Vector V = new Vector(p3.subtract(p1));

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
}

