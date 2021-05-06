package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * Returns list of intersection points with the triangle
 */
public class Triangle extends Polygon{
    /**
     * Constructor of the triangle class
     * @param p1
     * @param p2
     * @param p3
     */
    public Triangle(Point3D p1, Point3D p2, Point3D p3)
    {
        super(p1,p2,p3);
    }

    @Override
    public String toString() {
        return "Triangle{}" + super.toString();
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        List<Point3D> planeIntersections = super.plane.findIntersections(ray);
        if (planeIntersections == null) {
            return null;
        }

        Point3D P0 = ray.getP0();
        Vector v = ray.getDir();
        // we create the three vectors
        Vector v1 = vertices.get(0).subtract(P0);
        Vector v2 = vertices.get(1).subtract(P0);
        Vector v3 = vertices.get(2).subtract(P0);

        double a1 = v1.dotProduct(v1.crossProduct(v2).normalize());
        //if (isZero(a1)) return null;
        double a2 = v2.dotProduct(v2.crossProduct(v3).normalize());
        //if (isZero(a2)) return null;
        double a3 = v3.dotProduct(v3.crossProduct(v1).normalize());
        //if (isZero(a3)) return null;

        if (is_inside_triangle(a1, a2, a3)) {
            return planeIntersections;
        }

        return null;
    }

    private boolean is_inside_triangle(double a1, double a2, double a3) {
        return (a1 > 0 && a2 > 0 && a3 > 0) || (a1 < 0 && a2 < 0 && a3 < 0);
    }

}
