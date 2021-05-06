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
     * Constructor for Sphere class, gets a radius and a center point3D, and creates a new sphere
     * @param radius radius of a sphere
     * @param center a point3D, the center point of a sphere
     */
    public Sphere(double radius,Point3D center) {
        super(radius);
        _center = center;
    }

    /**
     *getter
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
     * find intersections point3D with sphere
     * @param ray ray for casting
     * @return list of intersections point3D or null if there were not found
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {

        // 𝑢 = 𝑂 − 𝑃0 distance from the center and the p0
        Vector u = _center.subtract(ray.getP0());
        Vector v = ray.getDir();
        double tm = u.dotProduct(v);
        //tm=v*u the distance between p0 and the point with makes 90 degrees with the center
        double d = alignZero(Math.sqrt(u.lengthSquared() - tm*tm));
        //d=u^2+tm^2 distance between the center and the point that  makes 90 degrees with the center
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
