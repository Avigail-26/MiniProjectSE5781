package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface Geometry is the class representing a Geometry for cartesian coordinate system
 */
public abstract class Geometry implements Intersectable {
    /**
     * return normal
     *
     * @param point
     * @return
     */
    protected Color _emission = Color.BLACK;

     public abstract Vector getNormal(Point3D point);

    /**
     * geometry's material
     */
    protected Material _material = new Material();

//
//    /**
//     * @param _emission sets emission to color recieved
//     * @param _material geometry's material
//     */
//    public Geometry(Color _emission, Material _material) {
//        this._material = _material;
//        this._emission = _emission;
//    }

    /**
     //* @param _emission sets emission to color recieved
     *                  sets material factors to (0,0,0)
     */
   // public Geometry(Color _emission) {
     //   this(_emission, new Material(0, 0, 0)) ;}

    public Geometry setEmission(Color emission) {
        _emission = emission;
        return this;
    }

    public Geometry setMaterial(Material m) {
        _material = m;
        return this;
    }
    /**
     * @return emission Color
     */
    public Color getEmission() {
        return _emission;
    }


    /**
     * @return geometry's material
     */
    public Material getMaterial() {
        return _material;
    }


}