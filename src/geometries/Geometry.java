package geometries;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is the class representing a Geometry for cartesian coordinate system
 */
public abstract class Geometry implements Intersectable{
    /**
     * return normal
     * @param point
     * @return
     */
    protected Color _emission = Color.BLACK;
    abstract Vector getNormal(Point3D point);

    public Geometry setEmission(Color emission) {
        _emission = emission;
        return this;
    }

    /**
     * @return emission Color
     */
    public Color getEmission() {
        return _emission;
    }
}
