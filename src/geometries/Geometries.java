package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Geometries class represents a list of shapes of all kinds
 */
public class Geometries implements Intersectable {
    List<Intersectable> _intersectables = null;

    public Geometries(){
        _intersectables = new LinkedList<>();
    }
/*
adds geometries to list
 */
    public void add(Intersectable... intersectables){
        _intersectables.addAll(Arrays.asList(intersectables));
    }
    public Geometries(Intersectable... intersectables){
        _intersectables = new LinkedList<>();
        add(intersectables);
    }


    /**
     * @return list of intersections from all shapes in list
     */


    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        List<GeoPoint> result = null;

        for (Intersectable item : _intersectables) {
            List<GeoPoint> itemIntersectionPoints = item.findGeoIntersections(ray);
            if (itemIntersectionPoints != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(itemIntersectionPoints);
            }
        }
        return result;
    }
}
