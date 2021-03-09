package primitives;

import java.util.Objects;

public class Ray {
    /**
     * Fields (point3D,vector)
     */
    Point3D _p0;
    Vector _dir;

    /**
     *
     * @param p0 point of origin of the ray
     * @param dir direction of the ray, normalized
     */
    public Ray(Point3D p0, Vector dir) {
        _p0 = p0;
        _dir = dir.normalized();
    }

    public Point3D getP0() {
        return _p0;
    }

    public Vector getDir() {
        return _dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals(ray._p0) && _dir.equals(ray._dir);
    }

    @Override
    public String toString() {
        return "[" + _p0 + _dir + ']';
    }
}
