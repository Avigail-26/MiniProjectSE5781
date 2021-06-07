package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource {

    private  Point3D _position;
    //protected static double _radius = 0d;


    /*
    _intensity – sets light's intensity to intensity
_position – light's position
_kC – constant attenuation
_kL – linear attenuation
_kQ – quadratic attenuation
     */
    private double _kC; //constant attenuatuion
    private double _kL; //linear attenuation
    private double _kQ; //quadratic attenuation

    public PointLight(Color intensity, Point3D position, double kC, double kL, double kQ) {
        super(intensity);
        _position = position;
        _kC = 1;
        _kL = 0;
        _kQ = 0;
    }

    public PointLight(Color intensity, Point3D pos) {
        super(intensity);
        _position=pos;
    }

   // public void setPosition(Point3D position) {this.position = position;}
    /**
     *set the Kc
     * @param kC1
     * there is no No attenuation with distance for kc
     */
    public PointLight setKc(double kC1) {
        _kC = kC1;
        return this;
    }

    /**
     *  chaining method
     *set the kL
     * there is attenuation with distance
     * @param kL1
     * @return PointLight
     */
    public PointLight setKl(double kL1) {
        _kL = kL1;
        return this;
    }

    /**
     * chaining method
     *set the kQ
     * kQ -> attenuation with distance squared - The most influential attenuation.
     *
     * @param kQ1
     * @return PointLight
     */
    public PointLight setKq(double kQ1) {
        _kQ = kQ1;
        return this;
    }
    @Override
    public Color getIntensity(Point3D p) {
        return (_intensity.reduce(getAttenuation(p)));
    }

    /**
     * @param p point in scene
     * @return attenuation in that point based on attenuation factors
     */
    protected double getAttenuation(Point3D p) {
        return _kC + _kL * p.distance(_position) + _kQ * p.distanceSquared(_position);
    }

    /**
     * @param p point on geometry surface
     * @return normalized vector from lightsource to point
     * (vector from light to p)
     */
    @Override
    public Vector getL(Point3D p) {
        if (p.equals(_position))//same point as light
        {
            return null;
        }
        return p.subtract(_position).normalize();
    }

   //@Override
   // public double getDistance(Point3D point) {
   //     return _position.distance(point);}
}

