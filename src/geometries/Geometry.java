package geometries;

import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is the class representing a Geometry for cartesian coordinate system
 */
public interface Geometry extends Intersectable{
    /**
     * return normal
     * @param point
     * @return
     */
    Vector getNormal(Point3D point);
}
