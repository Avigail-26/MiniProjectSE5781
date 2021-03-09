package primitives;

public class Point3D {

    public static Point3D ZERO = new Point3D(0d, 0d, 0d);

    final Coordinate _x;
    final Coordinate _y;
    final Coordinate _z;

    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        _x = x;
        _y = y;
        _z = z;
    }

    /**
     * basic constructor for Point3D
     * @param x value for X Coordinate
     * @param y value for Y Coordinate
     * @param z value for Z Coordinate
     */
    public Point3D(double x, double y, double z) {
        _x =new Coordinate(x);
        _y =new Coordinate(y);
        _z =new Coordinate(z);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals(point3D._x) && _y.equals(point3D._y) && _z.equals(point3D._z);
    }

    @Override
    public String toString() {
        return "(" + _x + "," + _y + "," + _z + ")";
    }

    /**
     *
     * @param point3D
     * @return (x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2
     */
    public double distanceSquared(Point3D point3D) {
        double xx = (point3D._x.coord - _x.coord) * (point3D._x.coord - _x.coord);
        double yy = (point3D._y.coord - _y.coord) * (point3D._y.coord - _y.coord);
        double zz = (point3D._z.coord - _z.coord) * (point3D._z.coord - _z.coord);

        return (xx + yy + zz);

    }

    /**
     * *
     * @param point3D
     * @return euclidean distance between 2  3D points
     */
    public double distance(Point3D point3D) {
        return Math.sqrt(distanceSquared(point3D));

    }

    public Vector subtract(Point3D pt2) {
        if (pt2.equals(this)) {
            throw new IllegalArgumentException("cannot create vector to point(0,0,0)");
        }
        return new Vector(new Point3D(
                _x.coord - pt2._x.coord,
                _y.coord - pt2._y.coord,
                _z.coord - pt2._z.coord
        ));
    }

    public Point3D add(Vector vector) {
        return new Point3D(
                _x.coord + vector._head._x.coord,
                _y.coord + vector._head._y.coord,
                _z.coord + vector._head._z.coord

        );
    }
}
