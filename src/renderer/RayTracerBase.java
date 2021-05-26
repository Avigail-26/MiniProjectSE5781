package renderer;

import Scene.Scene;
import primitives.Color;
import primitives.Ray;

public abstract class RayTracerBase {

    protected Scene _scene;

    public RayTracerBase(Scene scene) {
        _scene = scene;
    }

    public abstract Color traceRay(Ray ray);

}