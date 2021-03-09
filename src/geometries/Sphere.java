package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry{
    /**
     *fields (center)
     */
    Point3D _center;
    double _radius;
    /**
     * Constructor of Sphere
     * @param _radius
     * @param _center
     */


    public Sphere(Point3D _center, double _radius) {
        this._center = _center;
        this._radius = _radius;
    }

    /**
     * GetNormal Function
     * @param p
     * @return null
     */
    @Override
    public Vector getNormal(Point3D p)
    {
        return null;
    }

    /**
     * GetCenter function
     * @return center
     */
    public Point3D get_center() {
        return _center;
    }

    /**
     * ToString function
     * @return string with the center
     */
    @Override
    public String toString() {
        return super.toString()+
                " center" + _center ;
    }
}
