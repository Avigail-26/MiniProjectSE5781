package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Tube implements Geometry{

    /**
     * fields (axisRay)
     */
    final Ray _axisRay;
    final double _radius;

    /**
     * Constructor of the tube class
     * @param radius
     * @param axisRay
     */
    public Tube( double radius,Ray axisRay) {
        _radius = radius;
        _axisRay = axisRay;
    }

    public Ray getAxisRay() {
        return _axisRay;
    }

    public double getRadius() {
        return _radius;
    }

    /**
     * getNormal function
     * @param p-point3D
     * @return vector
     */
    @Override
    public Vector getNormal(Point3D p) {
        Point3D p0 = _axisRay.getP0();
        Vector v = _axisRay.getDir();
        if(p.equals(p0)){
            throw new IllegalArgumentException("p cannot be the origin of the tube's axis");
        }

        Vector P0_P = p.subtract(p0);

        double t = v.dotProduct(P0_P);

        if (isZero(t)){
            return P0_P.normalize();
        }

        //if p lay on the tube's axis
        // throw new IllegalArgumentException
        try {
            v.crossProduct(P0_P);
        }
        catch (IllegalArgumentException e){
            throw  new IllegalArgumentException("point p cannot be on the tube's axis");
        }

        Point3D O = p0.add(v.scale(t));

        return p.subtract(O).normalize();
    }
}


