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


    private boolean is_inside_triangle(double a1, double a2, double a3) {
        return (a1 > 0 && a2 > 0 && a3 > 0) || (a1 < 0 && a2 < 0 && a3 < 0);
    }

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        return super.findGeoIntersections(ray);
    }
}
