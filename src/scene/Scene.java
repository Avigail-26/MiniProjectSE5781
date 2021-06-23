package scene;

import elements.AmbientLight;
import elements.LightSource;
import geometries.Geometries;
import primitives.Color;

import java.util.LinkedList;
import java.util.List;

public class Scene {
    private final String _name;

    //according to Dan Zilberstein directives
    public Color background = Color.BLACK;
    public AmbientLight ambientlight = new AmbientLight(new Color(192, 192, 192), 1.d);
    /**
     * list of light sources in scene
     */
    public List<LightSource> lights;

    public Geometries geometries;

    public Scene(String name) {
        _name = name;
        geometries = new Geometries();
        this.lights = new LinkedList<LightSource>();
    }

    /**
     * @return list of lights in scene
     */
    public List<LightSource> getLights() {
        return lights;
    }

    //chaining set methods (this NOT a builder pattern)
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    public Scene setAmbientLight(AmbientLight ambientlight) {
        this.ambientlight = ambientlight;
        return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

}