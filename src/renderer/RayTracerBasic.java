package renderer;

import Scene.Scene;
import geometries.Intersectable;
import static geometries.Intersectable.GeoPoint;
import primitives.Color;

import primitives.Ray;

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
            return calcColor(closestPoint);
        }
        //ray did not intersect any geometrical object
        return _scene.background;
    }

    private Color calcColor(GeoPoint point) {
        return _scene.ambientlight.getIntensity()
                .add(point.geometry.getEmission());
    }
}