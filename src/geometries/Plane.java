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
     * @param vertex
     * @param vertex1
     * @param vertex2
     */
    public Plane(Point3D vertex, Point3D vertex1, Point3D vertex2) {
        _q0 = vertex;
        //_normal = null;

        Vector U = new Vector(vertex1.subtract(vertex));
        Vector V = new Vector(vertex2.subtract(vertex));
        Vector N = U.crossProduct(V);
        N.normalize();
        _normal = N;

    }
    /**
     * getNormal Function
     * @return normal vector
     */
    public Vector getNormal() {
        return _normal;
    }
    /**
     * Get Function
     * @return point3D
     */
    public Point3D get_q0() {
        return _q0;
    }


    /**
     * Function ToString
     * @return string with point and normal
     */
    @Override
    public String toString() {
        return  "point" + _q0 +  ", normal" + _normal;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return null;
    }
}

