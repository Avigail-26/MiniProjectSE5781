package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Util;
import primitives.Vector;

public class SpotLight extends PointLight{

    private final Vector _direction;


    public SpotLight(Color intensity, Point3D position, double kC, double kL, double kQ, Vector direction) {
        super(intensity, position, kC, kL, kQ);
        _direction = direction;
    }
    /***
     * Constructor for SpotLight objects
     * @param intensity The intensity of the light
     * @param pos The position of the light
     * @param dir The direction of the light
     */
    public SpotLight(Color intensity, Point3D pos, Vector dir) {
        super(intensity, pos);
        _direction = new Vector(dir);
    }

    /**
     * @param p point on geometry surface
     * @return intensity of light at point p
     * I0*max(0,direction*l)/kc+kl*d+k1*d^2
     */
    @Override
    public Color getIntensity(Point3D p) {
        double lightAngle = _direction.dotProduct(getL(p));
        if (Util.isZero(lightAngle))//no light shinning on it
        {
            return Color.BLACK;
        }

        double factor = Math.max(0, lightAngle);
        Color pointlightIntensity = super.getIntensity(p);
        return (pointlightIntensity.scale(factor));
    }
}
