package geometries;

import primitives.*;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/*
class represents a cylinder in 3D Cartesian coordinate
 */
public class Cylinder extends Tube{
    /**
     * cylinder height
     */
    double _height;

    /**
     * Constructor of the tube class
     *
     * @param radius
     * @param axisRay
     */
    public Cylinder(double radius,Ray axisRay, double height) {
        super(radius, axisRay);
        _height = height;
    }

    /**
     * Function getNormal
     * @param p
     * @return
     */
    @Override
    public Vector getNormal(Point3D p)
    {
        Point3D o = _axisRay.getP0();
        Vector v = _axisRay.getDir();

        // projection of P-O on the ray:
        double t;
        try {
            t = alignZero(p.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return p.subtract(o).normalize();
    }


    /**
     * Function getHeight
     * @return
     */

    public double getHeight() {
        return _height;
    }

    /**
     * Function ToString
     * @return string with toString of Tube and height
     */
    @Override
    public String toString() {
        return super.toString()+"height=" + _height ;
    }
}
