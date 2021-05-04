package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;

/*
interface intersectable with findintersections function
 */
public interface Intersectable {
    public List<Point3D> findIntersections(Ray ray);
}
