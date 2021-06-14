package primitives;

public class Material {

    /**
     * kd diffuse component of material
     */
    public double kD;

    /**
     * specular component of material
     */
    public double kS;
    /**
     * material's shininess
     */
    public int nShininess;


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
        kD =0d;
        kS = 0d;
        nShininess = 0;
    }

    public Material setKd(double kd) {
        this.kD = kd;
        return this;
    }
    public Material setKs(double ks) {
        this.kS = ks;
        return this;
    }
    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }
}
