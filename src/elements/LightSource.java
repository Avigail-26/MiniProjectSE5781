package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;


public interface LightSource {
    public Color getIntensity(Point3D p);
    public Vector getL(Point3D p);

    /**
     *
     * @param point point in scene
     * @return distance from light source to that point
     */
    double getDistance(Point3D point);

}
