package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{
    private final Vector _direction;

    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        _direction = direction;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return _intensity;
    }

    @Override
    public Vector getL(Point3D p) {
        return _direction.normalized();
    }

    @Override
    public double getDistance(Point3D point){
        return Double.POSITIVE_INFINITY;
    }

}
