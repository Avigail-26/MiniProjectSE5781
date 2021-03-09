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
     * @param axisRay
     * @param radius
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        _height = height;
    }

    /**
     * Constructor of Cylinder
     * @param _radius
     * @param _axisRay
     * @param _height
     */
    /**
     public Cylinder(double _radius, Ray _axisRay, double _height)
     {
     super(_radius, _axisRay);
     this._height = _height;
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
     * Function get_height
     * @return
     */
    public double get_height() {
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
