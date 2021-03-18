package geometries;

import primitives.*;

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
        return null;
    }

    /**
     * Function getHeight
     * @return
     */
    /**
     *

     */
    public double getHeight() {
        return _height;
    }

    /**
     * Function ToString
     * @return string with tostring of Tube and height
     */
    @Override
    public String toString() {
        return super.toString()+"height=" + _height ;
    }
}
