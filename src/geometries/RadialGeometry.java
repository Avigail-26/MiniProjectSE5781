package geometries;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;

import java.util.List;

public abstract class RadialGeometry extends Geometry {
    final protected double _radius;

    public RadialGeometry(double radius) {
        _radius = radius;

    }

    /**
     * @return
     */
    public double getRadius() {
        return _radius;
    }

}
