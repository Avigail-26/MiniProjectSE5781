package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry{

    /**
     * fields (axisRay)
     */
    Ray _axisRay;
    double _radius;

    /**
     * Constructor of the tube class
     * @param _radius
     * @param _axisRay
     */
    public Tube(Ray _axisRay, double _radius) {
        this._axisRay = _axisRay;
        this._radius = _radius;
    }

    /**
     * getNormal function
     * @param p-point3D
     * @return vector
     */
    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}


