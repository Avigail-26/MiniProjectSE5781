package elements;
import primitives.Color;
class Light {
    /**
     * intensity of ambient light color
     */
    final protected Color _intensity;

    Light(Color intensity){
        _intensity = intensity;
    }

    public Color getIntensity() {
        return _intensity;
    }

}
