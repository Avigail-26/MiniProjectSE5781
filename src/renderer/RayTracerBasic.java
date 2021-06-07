package renderer;

import Scene.Scene;
import elements.LightSource;
import geometries.Intersectable;
import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;

import primitives.Color;

import primitives.Material;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = _scene.geometries.findGeoIntersections(ray);
        if (intersections != null) {
            GeoPoint closestPoint = ray.getClosestGeoPoints(intersections);
            return calcColor(closestPoint,ray);
        }
        //ray did not intersect any geometrical object
        return _scene.background;
    }

   // private Color calcColor(GeoPoint point) {
     //   return _scene.ambientlight.getIntensity()
       //         .add(point.geometry.getEmission());}


    private Color calcColor(GeoPoint point, Ray ray) {
        return _scene.ambientlight.getIntensity()
                .add(point.geometry.getEmission()
                        .add(calcLocalEffects(point, ray)));
    }


    private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
        Vector v = ray.getDir();
        Vector n = intersection.geometry.getNormal(intersection.point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) {
            return Color.BLACK;
        }
        Material material = intersection.geometry.getMaterial();
        int nShininess = material._shininess;
        double kd = material._kD;
        double ks = material._kS;
        Color color = Color.BLACK;
        for (LightSource lightSource : _scene._lights) {
            Vector l = lightSource.getL(intersection.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sing(nv)
                Color lightIntensity = lightSource.getIntensity(intersection.point);
                color = color.add(calcDiffusive(kd, l, n, lightIntensity), calcSpecular(nl,ks, l, n, v, nShininess, lightIntensity));
            }
        }
        return color;

    }


    private Color calcSpecular(double nl,double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        //according to phong model formula
        //Calculating reflectance vector:
        Vector r=l.subtract(n.scale(nl*2));
        double minusvr=v.dotProduct(r)*-1;
        return lightIntensity.scale(ks*Math.pow(Math.max(0,minusvr),nShininess));
    }


    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        double factor =kd* Math.abs(l.dotProduct(n));
        return lightIntensity.scale(factor);

    }
}