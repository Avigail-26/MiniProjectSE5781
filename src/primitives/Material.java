package primitives;

public class Material {

    /**
     * kd diffuse component of material
     */
    public double _kD;

    /**
     * specular component of material
     */
    public double _kS;
    /**
     * material's shininess
     */
    public int _shininess;


    /**
     * sets all fields
     * @param kD diffuse coefficient
     * @param kS specuflar coefficient
     * @param nShininess shininess coefficient
     */
    //public Material(double kD, double kS, int nShininess) {
      //  _kD = kD;
        //_kS = kS;
        //_shininess = nShininess;}

    /**
     *
      kD diffuse coefficient
      kS specular coefficient
      nShininess shininess coefficient

     */
    public Material() {
        _kD = _kS = _shininess = 0;
    }

    public Material setKd(double _kd) {
        _kD = _kd;
        return this;
    }
    public Material setKs(double _ks) {
        _kS = _ks;
        return this;
    }
    public void setShininess(int shininess) {
        _shininess = shininess;
    }
}
