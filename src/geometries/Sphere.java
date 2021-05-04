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

public class Sphere extends RadialGeometry implements Geometry{
    /**
     *fields (center)
     */
    final protected Point3D _center;

    /**
     *
     * @param center
     * @param radius
     */
    public Sphere(double radius,Point3D center) {
        super(radius);
        _center = center;
    }

    /**
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
     *
     * @param p
     * @return
     */
    @Override
    public Vector getNormal(Point3D p) {
        Vector O_P = p.subtract(_center);
        return O_P.normalize();
    }

    /**
     * Returns list of intersection points with the sphere
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector u = _center.subtract(ray.getP0());
        Vector v = ray.getDir();
        double tm = u.dotProduct(v);
        double d = alignZero(Math.sqrt(u.lengthSquared() - tm*tm));

        if(d> _radius){
            return null;
        }
        double th = alignZero(Math.sqrt(_radius*_radius - d*d));

        //P is on the surface of the sphere
        if(isZero(th)){
            return null;
        }
        double t1= alignZero(tm+th);
        double t2= alignZero(tm-th);

        if(t1>0&&t2>0){
            return List.of(ray.getTargetPoint(t1),ray.getTargetPoint(t2));
        }
        if(t1>0){
            return List.of(ray.getTargetPoint(t1));
        }
        if(t2>0){
            return List.of(ray.getTargetPoint(t2));
        }
        return  null;
    }

}
