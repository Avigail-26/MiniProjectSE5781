package renderer;

import primitives.*;
import scene.Scene;
import elements.LightSource;

import static geometries.Intersectable.GeoPoint;
import static primitives.Point3D.ZERO;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

import java.util.List;

public class BasicRayTracer extends RayTracerBase {

    private static final double INITIAL_K = 1.0;
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;

    public BasicRayTracer(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = _scene.geometries.findGeoIntersections(ray);
        if (intersections != null) {
            GeoPoint closestPoint = ray.getClosestGeoPoints(intersections);
            return calcColor(closestPoint, ray);
        }
        //ray did not intersect any geometrical object
        return _scene.background;
    }

    // private Color calcColor(GeoPoint point) {
    //   return _scene.ambientlight.getIntensity()
    //         .add(point.geometry.getEmission());}


    private Color calcColor(GeoPoint point, Ray ray) {
        return _scene.ambientlight.getIntensity()
                .add(point.geometry.getEmission())
                .add(calcLocalEffects(point, ray));
    }


    private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
        Point3D point = intersection.point;
        Vector v = ray.getDir();
        Vector n = intersection.geometry.getNormal(point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) {
            return Color.BLACK;
        }
        Material material = intersection.geometry.getMaterial();
        int nShininess = material.nShininess;
        double kd = material.kD;
        double ks = material.kS;
        Color color = Color.BLACK;
        for (LightSource lightSource : _scene.lights) {
            Vector l = lightSource.getL(point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sing(nv)
                if (unshaded(lightSource,l,n,intersection)) {
                    Color lightIntensity = lightSource.getIntensity(point);
                    color = color.add(
                            calcDiffusive(kd, l, n, lightIntensity),
                            calcSpecular(ks, l, n, v, nShininess, lightIntensity)
                    );
                }
            }
        }
        return color;

    }


    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        //according to phong model formula
        //Calculating reflectance vector:
        double nl = n.dotProduct(l);
        if (isZero(nl)) {
            throw new IllegalArgumentException("nl cannot be Zero for scaling the normal vector");
        }
        if (n.getHead().equals(ZERO)) {
            throw new IllegalArgumentException("n cannot be Zero for scaling the normal vector");
        }

        Vector r = l.subtract(n.scale(nl * 2));
        double minusvr = alignZero(-1d * v.dotProduct(r));
        //if (minusvr <=0 ){
        //   return lightIntensity.scale(ks);}

        return lightIntensity.scale(ks * Math.max(0, Math.pow(minusvr, nShininess)));
    }


    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        double factor = kd * Math.abs(l.dotProduct(n));
        return lightIntensity.scale(factor);

    }

    private boolean unshaded(LightSource light,Vector l, Vector n, GeoPoint geoPoint) {
        Vector lightDirection = l.scale(-1);

        Ray lightRay = new Ray(geoPoint.point, lightDirection, n);

        double lightDistance = light.getDistance(geoPoint.point);

        List<GeoPoint> intersections = _scene.geometries.findGeoIntersections(lightRay,lightDistance);
        return intersections == null;
    }
}